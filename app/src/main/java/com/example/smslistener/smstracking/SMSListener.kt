package com.example.smslistener.smstracking

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.Build
import android.telephony.SmsMessage
import android.util.Log
import androidx.annotation.RequiresApi
import com.example.smslistener.smstracking.SMSTrackerService.Companion.BODY
import com.example.smslistener.smstracking.SMSTrackerService.Companion.FROM

class SMSListener : BroadcastReceiver() {
    private val TAG = "SMSListener"

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onReceive(context: Context?, intent: Intent?) {
        intent?.extras?.let {
            try {
                val pdus = it.get("pdus") as Array<*>
                for (i in pdus) {
                    val message = SmsMessage.createFromPdu(i as ByteArray)
                    val from = message.originatingAddress
                    val body = message.messageBody
                    Intent(context, SMSTrackerService::class.java).also {
                        it.putExtra(BODY, body)
                        it.putExtra(FROM, from)
                        context?.startForegroundService(it)
                    }
                }
            } catch (e: Exception) {
                Log.e(TAG, "onReceive: ")
                e.printStackTrace()
            }
        }
    }
}