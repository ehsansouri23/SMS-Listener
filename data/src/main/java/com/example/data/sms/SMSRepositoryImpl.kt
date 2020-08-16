package com.example.data.sms

import com.example.domain.sms.SMSModel
import com.example.domain.sms.SMSRepository

class SMSRepositoryImpl(
    private val smsRemoteDataSource: SMSRemoteDataSource
) : SMSRepository {

    override suspend fun sendSMS(url: String, smsList: List<SMSModel>): Boolean =
        smsRemoteDataSource.sendSMS(url, smsList)
}