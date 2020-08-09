package com.example.data.smslistener

import com.example.domain.BaseUseCase

class StartListeningSMSUseCase(
    private val smsListener: SMSListener
) : BaseUseCase<Unit, Unit>() {

    override suspend fun run(input: Unit) =
        smsListener.startListening()

}
