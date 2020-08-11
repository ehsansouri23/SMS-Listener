package com.example.smslistener.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.domain.sms.SMSTrackUseCase
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.koin.core.KoinComponent
import org.koin.core.inject

class MainViewModel(
    application: Application
) : AndroidViewModel(application), KoinComponent {

    val smsTrackUseCase: SMSTrackUseCase by inject()

    fun startTrackingSMS() {
        GlobalScope.launch {
            smsTrackUseCase.run(true)
        }
    }
}