package com.example.hack.Fragment

import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.hack.Adapter.InnerAdapter
import com.example.hack.Adapter.OpenAdapter
import com.example.hack.R
import com.example.hack.models.Category
import com.example.hack.models.DataItem
import kotlinx.android.synthetic.main.fragment_monitoring.view.*

import kotlinx.android.synthetic.main.item_1.view.*
import java.util.*
import kotlin.collections.ArrayList


class Monitoring : Fragment() {

    lateinit var innerAdapter: OpenAdapter
    lateinit var list1: ArrayList<DataItem>
    lateinit var root: View


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        root = inflater.inflate(R.layout.fragment_monitoring, container, false)
        loadDAta()
        root.btnBack.setOnClickListener {
            val ussdPageFragment = Home_fragment()
            fragmentManager
                ?.beginTransaction()
                ?.remove(ussdPageFragment)
                ?.commit()
            fragmentManager?.popBackStack()

        }
        var min = 25
        var max = 31
        val handler = Handler()
        val refresh: Runnable = object : Runnable {
            override fun run() {
                val random: Int = Random().nextInt(min)
                val random2: Int = Random().nextInt(max-1)
                val random4:Int=Random().nextInt(min+1)
                val random3: Int = Random().nextInt(max - min)+11
                root.temperature_measure.text = "$random\u2103"
                root.humidity.text = "$random4%"
                root.na.text = "$random2 ррм"
                root.ammoniu.text="$random3 мг/м3"
                handler.postDelayed(this, 2000)
            }
        }
        handler.postDelayed(refresh, 5000)





        root.rv2.layoutManager =
            LinearLayoutManager(view?.getContext(), LinearLayoutManager.HORIZONTAL, false)
        innerAdapter = OpenAdapter(list1,object :OpenAdapter.OnItemClickListener{
            override fun onMyItemClick(dataItem: DataItem, position: Int) {
                root.title.text=dataItem.description
                val random: Int = Random().nextInt(min+1)
                val random2: Int = Random().nextInt(max-1)
                val random4:Int=Random().nextInt(min+1)-3
                val random3: Int = Random().nextInt(max - min)+11
                root.temperature_measure.text = "$random\u2103"
                root.humidity.text = "$random4%"
                root.na.text = "$random2 ррм"
                root.ammoniu.text="$random3 мг/м3"
            }

            override fun onMyLongItemClick(dataItem: DataItem) {

            }

        })
        root.rv2.adapter = innerAdapter
        return root

    }

    private fun loadDAta() {
        list1 = ArrayList()
        list1.add(
            DataItem(
                "https://urozhayniy.com/wp-content/uploads/2020/05/c.jpg",
                "Птицеферма 1",
                "Сектор 1"
            )
        )

        list1.add(
            DataItem(
                "https://vipidei.com/wp-content/uploads/2019/08/mini-pticeferma.jpeg",
                "Птицеферма 2",
                "Сектор 2"
            )
        )
        list1.add(
            DataItem(
                "https://www.amur.life/res/news/7783/928x_/43bf7b8c5cc8f046c61958055eb17680.jpg",
                "Птицеферма 3",
                "Сектор 3"
            )
        )

        list1.add(
            DataItem(
                "https://www.equipnet.ru/netcat_files/userfiles/52079/Pticeferma/003.jpg",
                "Птицеферма 3",
                "Сектор 3"
            )
        )

    }


}

