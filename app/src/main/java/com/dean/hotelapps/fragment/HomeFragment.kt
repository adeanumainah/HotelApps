package com.dean.hotelapps.fragment


import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
import com.dean.hotelapps.adapter.AdapterRecyclerHotel
import com.dean.hotelapps.activity.HotelPopularActivity
import com.dean.hotelapps.Model
import com.dean.hotelapps.R
import com.dean.hotelapps.activity.DetailHotelActivity
import com.synnapps.carouselview.CarouselView
import com.synnapps.carouselview.ImageListener
import kotlinx.android.synthetic.main.fragment_home.*

/**
 * A simple [Fragment] subclass.
 */
class HomeFragment : Fragment() {
    //    private val hotelList = ArrayList<Model>()
    private lateinit var hotelAdapter: AdapterRecyclerHotel

    companion object {
        fun defaultFragment(): HomeFragment {
            val homeFragment = HomeFragment()
            val bundle = Bundle()
            homeFragment.arguments = bundle
            return homeFragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    val imageContentSlider = intArrayOf(
        R.drawable.hotel1,
        R.drawable.hotel2,
        R.drawable.hotel3,
        R.drawable.hotel4,
        R.drawable.hotel5
    )

    val imageContentListener: ImageListener = object : ImageListener {
        override fun setImageForPosition(position: Int, imageView: ImageView) {
            imageView.setImageResource(imageContentSlider[position])

        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val carouselView = is_main as CarouselView
        carouselView.setImageListener(imageContentListener)
        carouselView.setPageCount(imageContentSlider.size)

        showRecyclerList()

        tv_see_all.setOnClickListener {
            val intent = Intent(context, HotelPopularActivity::class.java)
            startActivity(intent)
        }

    }

    private fun showRecyclerList() {
        hotelAdapter = AdapterRecyclerHotel { showSelected(it) }
        hotelAdapter.notifyDataSetChanged()
        hotelAdapter.setData(getListhotel())
        rv_popular.setHasFixedSize(true)
        rv_popular.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        rv_popular.adapter = hotelAdapter
    }

    private fun showSelected(it: Model) {
        val page = Intent(context, DetailHotelActivity::class.java)
        page.putExtra(DetailHotelActivity.KEY_POPULAR_HOTEL, it)
        startActivity(page)
    }


    private fun getListhotel(): ArrayList<Model> {
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

}
