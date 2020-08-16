package com.example.data.di

import com.example.data.base.ApiFactory
import com.example.data.sms.SMSRemoteDataSource
import com.example.data.sms.SMSRemoteDataSourceImpl
import com.example.data.sms.SMSRepositoryImpl
import com.example.domain.sms.SMSRepository
import org.koin.dsl.module

private val smsModule = module {
    factory {
        ApiFactory.createSMSApi()
    }
    factory<SMSRemoteDataSource> {
        SMSRemoteDataSourceImpl(get())
    }
    single<SMSRepository> {
        SMSRepositoryImpl(get())
    }
}