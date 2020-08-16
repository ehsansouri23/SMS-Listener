package com.example.data.base

import com.example.data.sms.api.SMSApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiFactory {

    fun createSMSApi(): SMSApi =
        Retrofit.Builder()
            .baseUrl("https://google.com") //sample server url.
            .addConverterFactory(
                GsonConverterFactory.create()
            )
            .build().create(SMSApi::class.java)
}