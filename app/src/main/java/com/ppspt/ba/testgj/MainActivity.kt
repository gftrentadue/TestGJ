package com.ppspt.ba.testgj

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.ppspt.ba.testgj.view_model.MainViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = MainViewModel()
        viewModel.getItemsToShow()?.observe(this, Observer {
            Log.d("Coupons", "List: $it")
        })


    }
}
