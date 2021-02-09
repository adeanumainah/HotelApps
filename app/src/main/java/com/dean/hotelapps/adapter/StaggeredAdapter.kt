package com.dean.hotelapps.adapter

import android.graphics.ColorSpace
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.dean.hotelapps.Model
import com.dean.hotelapps.R
import kotlinx.android.synthetic.main.item_staggered.view.*

class StaggeredAdapter (private val listStaggered: ArrayList<Model>) :
    RecyclerView.Adapter<StaggeredAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_staggered, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = listStaggered.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(listStaggered[position])
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        fun bind(model: Model) {
            with(itemView) {
                Glide.with(itemView.context).load(model.image)
                    .apply(RequestOptions().override(500))
                    .into(iv_staggered_name)

                tv_staggered_name.text = model.title
                tv_staggered_address.text = model.address
                tv_staggered_desc.text = model.desc
            }
        }

    }
}