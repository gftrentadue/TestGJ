package com.ppspt.ba.testgj

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.ppspt.ba.testgj.beans.RetrofitItem
import com.ppspt.ba.testgj.interfaces.WebServiceApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    private lateinit var retrofit: Retrofit
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        retrofit = Retrofit.Builder().baseUrl(getString(R.string.url))
            .addConverterFactory(GsonConverterFactory.create()).build()

        val service = retrofit.create(WebServiceApi::class.java)
        val call = service.getAllItems()
        call.enqueue(object : Callback<RetrofitItem> {
            override fun onFailure(call: Call<RetrofitItem>?, t: Throwable?) {
                Log.e("getAllCall", "ERROR RETRIEVING DATA $t")
            }

            override fun onResponse(call: Call<RetrofitItem>?, response: Response<RetrofitItem>?) {
                if (response?.code() == 200) {
                    val body = response.body()

                    if (body.meta.success) {
                        Log.d("getAllCall", "Retrieved item: $body")
                    }
                }
            }

        })
    }
}
