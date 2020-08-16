package com.example.domain.sms

interface SMSRepository {

    suspend fun sendSMS(url: String, smsList: List<SMSModel>): Boolean
}