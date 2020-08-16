package com.example.domain.sms

import com.example.domain.BaseUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class SendSMSUseCase(
    private val smsRepository: SMSRepository
) : BaseUseCase<List<SMSModel>, Boolean>() {

    override suspend fun run(smsList: List<SMSModel>): Boolean = withContext(Dispatchers.IO) {
        smsRepository.sendSMS(smsList)
    }
}