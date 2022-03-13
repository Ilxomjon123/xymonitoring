package com.example.hack.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.hack.Adapter.HelperAdapter
import com.example.hack.R
import com.example.hack.models.Helper
import kotlinx.android.synthetic.main.fragment_help_fragment.view.*
import kotlinx.android.synthetic.main.fragment_home_page.view.*
import kotlinx.android.synthetic.main.fragment_monitoring.view.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [Help_fragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class Help_fragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    lateinit var root: View
    lateinit var myAdapte:HelperAdapter
    lateinit var list:ArrayList<Helper>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        root= inflater.inflate(R.layout.fragment_help_fragment, container, false)
        root.btnBac.setOnClickListener {
            val ussdPageFragment = Home_fragment()
            val fragment1 = Home_fragment()
            fragmentManager
                ?.beginTransaction()
                ?.replace(R.id.container, fragment1)
                ?.commit()
            fragmentManager?.popBackStack()
        }
        loadDATA()
        root.rv3.layoutManager = LinearLayoutManager(view?.getContext())
        myAdapte= HelperAdapter(list)
        root.rv3.adapter = myAdapte


        return root
    }

    private fun loadDATA() {
        list= ArrayList()
        list.add(Helper("https://www.pikpng.com/pngl/m/129-1296396_man-office-worker-emoji-singer-icon-png-clipart.png","ZOO Doctor","Контакты:+998943230002"))
        list.add(Helper("https://www.pikpng.com/pngl/m/129-1296396_man-office-worker-emoji-singer-icon-png-clipart.png","Cleaning managing","Контакты:+998943230002"))
        list.add(Helper("https://www.pikpng.com/pngl/m/129-1296396_man-office-worker-emoji-singer-icon-png-clipart.png","Service Center","Контакты:+998943230002"))
        list.add(Helper("https://www.pikpng.com/pngl/m/129-1296396_man-office-worker-emoji-singer-icon-png-clipart.png","ZOO planet","Контакты:+998943230002"))
        list.add(Helper("https://www.pikpng.com/pngl/m/129-1296396_man-office-worker-emoji-singer-icon-png-clipart.png","Dispatch","Контакты:+998943230002"))
        list.add(Helper("https://www.pikpng.com/pngl/m/129-1296396_man-office-worker-emoji-singer-icon-png-clipart.png","Improve","Контакты:+998943230002"))
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment Help_fragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String) =
            Help_fragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)

                }
            }
    }


}