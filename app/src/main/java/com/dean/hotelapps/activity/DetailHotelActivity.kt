package com.dean.hotelapps.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.dean.hotelapps.Model
import com.dean.hotelapps.R
import kotlinx.android.synthetic.main.activity_detail_hotel.*

class DetailHotelActivity : AppCompatActivity() {

    companion object{
        const val KEY_POPULAR_HOTEL = "key_popular_hotel"
    }

    private var hotels: Model? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_hotel)
        hotels = intent.getParcelableExtra(KEY_POPULAR_HOTEL)

        tv_title_detail.text = hotels?.title
        tv_address_detail.text = hotels?.address
        tv_description_detail.text = hotels?.desc
        Glide.with(this).load(hotels?.image).apply(RequestOptions()).override(500)
            .into(iv_detail)
    }
}
