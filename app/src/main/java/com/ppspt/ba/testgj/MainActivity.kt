package com.ppspt.ba.testgj

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import com.ppspt.ba.testgj.adapters.CouponsAdapter
import com.ppspt.ba.testgj.view_model.MainViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel
    private lateinit var adapter: CouponsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = MainViewModel()
        viewModel.getItemsToShow()?.observe(this, Observer {
            Log.d("Coupons", "List: $it")

            adapter = CouponsAdapter(this.applicationContext, it)

            val layoutManager = GridLayoutManager(
                this.applicationContext,
                GridLayoutManager.DEFAULT_SPAN_COUNT,
                GridLayoutManager.HORIZONTAL,
                false
            )

            itemsRV.layoutManager = layoutManager
            itemsRV.adapter = adapter
        })
    }
}
