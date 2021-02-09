package com.dean.hotelapps.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.dean.hotelapps.Model
import com.dean.hotelapps.R
import kotlinx.android.synthetic.main.item_row_list.view.*

class AdapterRecyclerHotel (private val listener : (Model) -> Unit)
    : RecyclerView.Adapter<AdapterRecyclerHotel.ViewHolder>(){
    private val listHotel = ArrayList<Model>()

    fun setData(items: ArrayList<Model>){
        listHotel.clear()
        listHotel.addAll(items)
        //mensyncron data
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_row_list, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = listHotel.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(listHotel[position],listener)
    }

    class ViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView){
        fun bind(hotels: Model, listener: (Model) -> Unit) {
            with(itemView) {
                Glide.with(itemView.context).load(hotels.image)
                    .apply(RequestOptions().override(300)).into(iv_popular)

                tv_name_hotel.setText(hotels.title)
                tv_address.setText(hotels.address)

                itemView.setOnClickListener { listener(hotels) }

            }
        }

    }
}