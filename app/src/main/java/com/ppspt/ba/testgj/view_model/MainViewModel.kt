package com.ppspt.ba.testgj.view_model

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ppspt.ba.testgj.beans.Coupon
import com.ppspt.ba.testgj.beans.RetrofitItem
import com.ppspt.ba.testgj.interfaces.WebServiceApi
import com.ppspt.ba.testgj.web_service.WebService
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainViewModel : ViewModel() {
    private var itemsList: MutableLiveData<ArrayList<Coupon>>? = null
    private val scope = CoroutineScope(Dispatchers.IO)

    fun getItemsToShow(): LiveData<ArrayList<Coupon>>? {
        scope.launch {
            val service = WebService.retrofit().create(WebServiceApi::class.java)
            val call = service.getAllItems()

            call.enqueue(object : Callback<RetrofitItem> {
                override fun onFailure(call: Call<RetrofitItem>?, t: Throwable?) {
                    Log.e("getAllCall", "ERROR RETRIEVING DATA $t")
                }

                override fun onResponse(
                    call: Call<RetrofitItem>?,
                    response: Response<RetrofitItem>?
                ) {
                    if (response?.code() == 200) {
                        val body = response.body()

                        if (body.meta.success) {
                            Log.d("getAllCall", "Retrieved item: $body")

                            itemsList = MutableLiveData()
                            itemsList!!.postValue(body.coupons[0])
                        }
                    }
                }
            })
        }

        return itemsList

    }
}