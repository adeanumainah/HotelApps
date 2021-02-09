package com.dean.hotelapps.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.dean.hotelapps.Model
import com.dean.hotelapps.R

class AdapterHotel internal constructor(private val context: Context) : BaseAdapter() {
    internal var hotel = arrayListOf<Model>()

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        var view = p1
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.item_row, p2, false)
        }

        val viewHolder = ViewHolder(view as View)
        val city = getItem(p0) as Model
        viewHolder.bind(city)
        return view
    }

    override fun getItem(p0: Int): Any {
        return hotel[p0]
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    override fun getCount(): Int = hotel.size


    private inner class ViewHolder(view: View) {
        private val tvTitle: TextView = view.findViewById(R.id.tv_title)
        private val tvAddress: TextView = view.findViewById(R.id.tv_address_main)
        private val image: ImageView = view.findViewById(R.id.img_view)

        internal fun bind(model: Model) {
            tvTitle.text = model.title
            tvAddress.text = model.address
            Glide.with(context).load(model.image).circleCrop()
                .into(image)
        }
    }
}


