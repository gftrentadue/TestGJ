package com.ppspt.ba.testgj.web_service

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

const val BASE_URL = "https://pastebin.com/raw/vF9p93Zu/"

object WebService {

    fun retrofit(): Retrofit = Retrofit.Builder().baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create()).build()

}