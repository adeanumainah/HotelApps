package com.dean.hotelapps.activity

import android.content.res.TypedArray
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.dean.hotelapps.Model
import com.dean.hotelapps.R
import com.dean.hotelapps.adapter.AdapterHotel
import com.dean.hotelapps.adapter.StaggeredAdapter
import kotlinx.android.synthetic.main.activity_hotel_popular.*
import kotlinx.android.synthetic.main.fragment_home.*

class HotelPopularActivity : AppCompatActivity() {
    private val listHotel = ArrayList<Model>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hotel_popular)
        supportActionBar?.hide()

        rv_all_popular.setHasFixedSize(true)
        listHotel.addAll(getListHotel())
        showRecyclerGrid()
    }

    private fun getListHotel(): ArrayList<Model> {
        val dataTitle = resources.getStringArray(R.array.title)
        val dataAddress = resources.getStringArray(R.array.address)
        val dataDesc = resources.getStringArray(R.array.desc)
        val dataPhoto = resources.obtainTypedArray(R.array.image)

        //u meluping
        val listHotel = ArrayList<Model>()

        for (position in dataTitle.indices) {
            val hotel = Model(
                dataTitle[position],
                dataAddress[position],
                dataDesc[position],
                dataPhoto.getResourceId(position, -1)
            )
            listHotel.add(hotel)
        }
        return listHotel
    }

    private fun showRecyclerGrid() {
        val layoutManagerStaggered = StaggeredGridLayoutManager(2, GridLayoutManager.VERTICAL)
        rv_all_popular.layoutManager = layoutManagerStaggered
        rv_all_popular.adapter = StaggeredAdapter(listHotel)
    }


}
