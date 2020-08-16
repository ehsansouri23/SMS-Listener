package com.example.domain.sms

interface SMSRepository {

    suspend fun sendSMS(smsList: List<SMSModel>): Boolean
}