package com.example.smslistener.smstracking

import android.app.Service
import android.content.Intent
import android.content.IntentFilter
import android.os.IBinder

class SMSTrackerService : Service() {

    private lateinit var smsListener: SMSListener

    override fun onBind(intent: Intent?): IBinder? = null

    override fun onCreate() {
        super.onCreate()
        smsListener = SMSListener()
        registerReceiver(
            smsListener,
            IntentFilter("android.provider.Telephony.SMS_RECEIVED")
        )
    }

    override fun onDestroy() {
        unregisterReceiver(smsListener)
    }

    companion object {
        val BODY = "body"
        val FROM = "from"
    }
}