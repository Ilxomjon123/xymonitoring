package com.example.hack.Fragment


import android.os.Bundle
import android.provider.ContactsContract
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.core.view.GravityCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.hack.Adapter.MyAdapter
import com.example.hack.R
import com.example.hack.models.Category
import com.example.hack.models.DataItem
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.fragment_home_page.*
import kotlinx.android.synthetic.main.fragment_home_page.view.*


class Home_fragment : Fragment(), NavigationView.OnNavigationItemSelectedListener {


    lateinit var root: View
    lateinit var myAdapter: MyAdapter
    lateinit var list1: ArrayList<DataItem>
    lateinit var list: ArrayList<Category>
    val monitoring = Monitoring()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        root = inflater.inflate(R.layout.fragment_home_page, container, false)
        root.navigation1.setNavigationItemSelectedListener(this)
        val bundle = Bundle()
        loadData()
        root.menu.setOnClickListener {
            drawer.openDrawer(GravityCompat.START)

        }
        root.rv1.layoutManager = LinearLayoutManager(view?.getContext())
        myAdapter = MyAdapter(list, object : MyAdapter.OnMyItemClickListener {

            override fun onMyClick(category: Category, position: Int) {

                fragmentManager?.beginTransaction()
                    ?.replace(R.id.container, monitoring)
                    ?.addToBackStack(monitoring.toString())
                    ?.commit()
            }


        })

        root.rv1.adapter = myAdapter
        return root

    }

    private fun loadData() {
        list = ArrayList()
        list1 = ArrayList<DataItem>()
        val green_list = ArrayList<DataItem>()
        val freez_list = ArrayList<DataItem>()
        val fish_list = ArrayList<DataItem>()
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
        freez_list.add(
            DataItem(
                "https://paneli-s.ru/images/main/Anna/1/xolodilnyie_kameryi_iz_sendvich_panelej_5.jpg",
                "Холодильные камеры 1",
                "Сектор 1"
            )
        )
        freez_list.add(
            DataItem(
                "https://ttrade-ltd.com.ua/Media/files/filemanager/dveri_1.jpg",
                "Холодильные камеры 2",
                "Сектор 2"
            )
        )
        freez_list.add(
            DataItem(
                "https://profholod.ru/upload/medialibrary/14d/NH6A5688.jpg",
                        "Холодильные камеры 3",
                "Сектор 3"
            )
        )
        freez_list.add(
            DataItem(
                "https://refpremium.ru/images/news/avtonomnaya-holodilnaya-kamera.jpg",
                "Холодильные камеры 4",
                "Сектор 4"
            )
        )
        green_list.add(DataItem("https://www.datocms-assets.com/48825/1622731345-headerabforgrenhouse.jpg","Теплицы 1","Сектор 1"))
        green_list.add(DataItem("https://cms.qz.com/wp-content/uploads/2021/03/Singapore-Farms-Lead-4.jpg","Теплицы 2","Сектор 2"))
        green_list.add(DataItem("https://ak.picdn.net/shutterstock/videos/6956938/thumb/1.jpg","Теплицы 3","Сектор 3"))
        green_list.add(DataItem("https://ak.picdn.net/shutterstock/videos/2694239/thumb/1.jpg","Теплицы 4","Сектор 4"))
fish_list.add(DataItem("https://business-gu.ru/800/600/https/www.flashnord.com/sites/default/files/uploads/main/3523/1322394857_sadki.jpg","Рыбхоз 1","Сектор 1"))
        fish_list.add(DataItem("https://avatars.mds.yandex.net/get-altay/4200646/2a0000017536c6136bce6be2125e7ef2cc2b/XXL","Рыбхоз 2","Сектор 2"))
        fish_list.add(DataItem("https://cdnn11.img.sputnik.by/img/07e4/0a/17/1045969378_664:0:2502:2022_1920x0_80_0_0_b4ea2732130f09211f419529f5cd227b.jpg","Рыбхоз 2","Сектор 3"))
        fish_list.add(DataItem("http://idei-biz.com/wp-content/uploads/2013/12/virashivanie-karpa-v-sadkah.jpg","Рыбхоз 2","Сектор 4"))

        var category1 = Category("Птицефермы", list1)
        var category2 = Category("Холодильные камеры", freez_list)
        var category3 = Category("Теплицы", green_list)
        var category4 = Category("Рыбхоз", fish_list)
        list.add(category1)
        list.add(category2)
        list.add(category3)
        list.add(category4)

    }


    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        return true
    }
}



