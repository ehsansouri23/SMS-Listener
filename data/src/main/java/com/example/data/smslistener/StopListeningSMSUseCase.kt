package com.example.data.smslistener

import com.example.domain.BaseUseCase

class StopListeningSMSUseCase(
    private val smsListener: SMSListener
) : BaseUseCase<Unit, Unit>() {

    override suspend fun run(input: Unit) =
        smsListener.stopListening()
}