package com.example.data.sms.api

import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Url

interface SMSApi {

    suspend fun sendSMS(
        @Url url: String,
        @Body smsList: List<SMSBody>
    ): Response<Unit>
}