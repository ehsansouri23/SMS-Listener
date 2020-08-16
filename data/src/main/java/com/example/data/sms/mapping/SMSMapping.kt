package com.example.data.sms.mapping

import com.example.data.sms.api.SMSBody
import com.example.domain.sms.SMSModel

fun SMSModel.toSMSBody(): SMSBody =
    SMSBody(sender, body)