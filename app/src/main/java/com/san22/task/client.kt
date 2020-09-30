package com.san22.task

import com.google.gson.FieldNamingPolicy
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object client {

    private val gson= GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).setLenient().create()

    val retrofit_Login=Retrofit.Builder().baseUrl("https://www.finnovationz.com").addConverterFactory(
        GsonConverterFactory.create(
            gson)).build()

    val api_Login= retrofit_Login.create(MyService::class.java)
}
//baseUrl("https://www.finnovationz.com")