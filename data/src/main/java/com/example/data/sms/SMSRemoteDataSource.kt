package com.example.data.sms

import com.example.domain.sms.SMSModel

interface SMSRemoteDataSource {

    suspend fun sendSMS(url: String, smsList: List<SMSModel>): Boolean
}