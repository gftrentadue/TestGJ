package com.ppspt.ba.testgj.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import com.ppspt.ba.testgj.R
import com.ppspt.ba.testgj.beans.Coupon

class CouponsAdapter(private val context: Context, itemsList: ArrayList<Coupon>) :
    RecyclerView.Adapter<CouponsAdapter.CouponViewHolder>() {

    private var elemList = arrayListOf<Coupon>()

    init {
        elemList.addAll(itemsList)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CouponViewHolder {
        val view =
            LayoutInflater.from(context).inflate(R.layout.recycleview_item_layout, parent, false)

        return CouponViewHolder(view)
    }

    override fun getItemCount() = elemList.size

    override fun onBindViewHolder(holder: CouponViewHolder, position: Int) {
        val elemToBind = elemList[position]

        holder.bind(elemToBind.name)
    }

    class CouponViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val nameTextView = itemView.findViewById<AppCompatTextView>(R.id.couponNameTV)

        fun bind(couponName: String) {
            nameTextView.text = couponName
        }
    }
}