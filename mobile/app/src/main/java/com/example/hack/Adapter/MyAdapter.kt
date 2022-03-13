package com.example.hack.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.hack.R
import com.example.hack.models.Category
import com.example.hack.models.DataItem
import kotlinx.android.synthetic.main.fragment_home_page.view.*
import kotlinx.android.synthetic.main.item_1.view.*

class MyAdapter(var list: List<Category>, var myItemClickListener: OnMyItemClickListener) :
    RecyclerView.Adapter<MyAdapter.VH>() {


    inner class VH(view: View) : RecyclerView.ViewHolder(view) {

        fun onBind(category: Category) {
            itemView.category_name.text = category.category_name
            var innerAdapter = InnerAdapter(category.list)
            itemView.inner_rv.layoutManager =
                LinearLayoutManager(itemView.context, LinearLayoutManager.HORIZONTAL, false)
            itemView.inner_rv.adapter = innerAdapter
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        return VH(LayoutInflater.from(parent.context).inflate(R.layout.item_1, parent, false))
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: VH, position: Int) {

        val category = list[position]
        holder.onBind(category)
        holder.itemView.btn.setOnClickListener {
            myItemClickListener.onMyClick(category,position,)
        }


    }

    interface OnMyItemClickListener {
        fun onMyClick(category: Category,position: Int)
    }
}
