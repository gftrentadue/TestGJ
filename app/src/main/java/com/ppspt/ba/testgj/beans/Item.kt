package com.ppspt.ba.testgj.beans

data class RetrofitItem(
    val meta: Meta,
    val coupons: Array<ArrayList<Coupon>>,
    val categories: Array<ArrayList<Category>>,
    val total: Int
)

data class Meta(
    val message: String?,
    val errors: ArrayList<Any>,
    val validationErrors: ArrayList<Any>,
    val success: Boolean
)

data class Category(
    val id: String,
    val name: String,
    val image: String
)

data class Coupon(
    val EAN: String,
    val product_id: String,
    val category_id: String,
    val campaign_id: String,
    val coupon_id: String,
    val id: String,
    val name: String,
    val subtitle: String,
    val text: String,
    val currency: String,
    val temporary: String,
    val priority: String,
    val top_pick: String,
    val enable_proximity_features: Int,
    val requires_unlock: Int,
    val previously_redeemed: String,
    val shared_campaign_id: String?,
    val parent_id: String,
    val enable_user_sharing: String,
    val discount_type: String,
    val discount_value: Int,
    val discount_description: String,
    val is_shared: Boolean,
    val shops: ArrayList<String>,
    val tags: ArrayList<String>,
    val preferences: ArrayList<Any>,
    val image_url: String,
    val image_urls: HashMap<String, String>,
    val status: String,
    val available_in_all_sainsbury: Boolean,
    val available_in_all_waitrose: Boolean,
    val available_in_all_tesco: Boolean,
    val available_in_all_iceland: Boolean,
    val custom_stores: String,
    val map_description: Any?,
    val start_date: String,
    val expire_date: String
)
