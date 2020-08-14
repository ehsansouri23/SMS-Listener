package com.example.smslistener.smstracking

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.annotation.RequiresApi
import com.example.domain.preferences.GetUrlUseCase
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.koin.core.KoinComponent
import org.koin.core.inject

class BootCompleteReceiver : BroadcastReceiver(), KoinComponent {

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onReceive(context: Context?, intent: Intent?) {
        val getUrl: GetUrlUseCase by inject()
        //this method is not tied to application views.
        // so it is not bad practice to use GlobalScope
        GlobalScope.launch {
            if (getUrl.run(Unit) != "")
                context?.startForegroundService(Intent(context, SMSTrackerService::class.java))
        }
    }
}