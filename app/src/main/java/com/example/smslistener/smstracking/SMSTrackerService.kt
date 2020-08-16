package com.example.smslistener.smstracking

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.Service
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Build
import android.os.IBinder
import androidx.annotation.RequiresApi
import androidx.core.app.NotificationCompat
import com.example.smslistener.R

class SMSTrackerService : Service() {

    private lateinit var smsListener: SMSListener

    override fun onBind(intent: Intent?): IBinder? = null

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate() {
        super.onCreate()
        smsListener = SMSListener()
        registerReceiver(
            smsListener,
            IntentFilter("android.provider.Telephony.SMS_RECEIVED")
        )
        startForeground(1, showNotification())
    }

    override fun onDestroy() {
        unregisterReceiver(smsListener)
        super.onDestroy()
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun showNotification(): Notification {
        val notificationManager =
            getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        NotificationChannel("SMS", "SMS", NotificationManager.IMPORTANCE_HIGH)
            .let { notificationManager.createNotificationChannel(it) }
        return NotificationCompat.Builder(applicationContext, "SMS").apply {
            setContentTitle(getString(R.string.listening_to_SMSs))
            setSmallIcon(R.drawable.ic_launcher_foreground)
        }.build().also {
            notificationManager.notify(1, it)
        }

    }

    companion object {
        const val BODY = "body"
        const val FROM = "from"
    }
}