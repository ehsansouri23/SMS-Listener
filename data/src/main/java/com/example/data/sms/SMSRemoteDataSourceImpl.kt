package com.example.data.sms

import com.example.data.sms.api.SMSApi
import com.example.data.sms.mapping.toSMSBody
import com.example.domain.sms.SMSModel

class SMSRemoteDataSourceImpl(
    private val smsApi: SMSApi
) : SMSRemoteDataSource {

    override suspend fun sendSMS(url: String, smsList: List<SMSModel>): Boolean =
        smsApi.sendSMS(url,
            smsList.map {
                it.toSMSBody()
            }).run {
            true
        } // TODO: 8/16/20 handle network errors

}