package com.ppspt.ba.testgj.interfaces

import com.ppspt.ba.testgj.beans.RetrofitItem
import retrofit2.Call
import retrofit2.http.GET

interface WebServiceApi {
    @GET("https://pastebin.com/raw/vF9p93Zu")
    fun getAllItems(): Call<RetrofitItem>
}