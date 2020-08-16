package com.example.data.sms.api

import com.google.gson.annotations.SerializedName

data class SMSBody(
    @SerializedName("sender") val sender: String,
    @SerializedName("body") val body: String
)