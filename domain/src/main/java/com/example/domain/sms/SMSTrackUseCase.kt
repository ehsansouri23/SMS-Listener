package com.example.domain.sms

import com.example.domain.BaseUseCase

class SMSTrackUseCase(
    private val tracker: SMSTracker
) : BaseUseCase<Boolean, Unit>() {

    override suspend fun run(track: Boolean) {
        if (track)
            tracker.startTracking()
        else tracker.stopTracking()
    }
}