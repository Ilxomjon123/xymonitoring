package com.example.hack.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.hack.R
import com.example.hack.models.DataItem
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.inner_item.view.*
import java.lang.Exception

class InnerAdapter(var list:List<DataItem>) : RecyclerView.Adapter<InnerAdapter.VH>(){

    class VH(view: View): RecyclerView.ViewHolder(view){

        fun onBind(dataItem: DataItem){
            Picasso.get().load(dataItem.img).placeholder(R.drawable.place).into(itemView.img,object:
                Callback {
                override fun onSuccess() {
                    itemView.progress.visibility = View.INVISIBLE
                }

                override fun onError(e: Exception?) {

                }
            })
            itemView.tv1.isSelected = true
            itemView.tv1.text = dataItem.title
            itemView.tv2.text = dataItem.description
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        return VH(LayoutInflater.from(parent.context).inflate(R.layout.inner_item,parent,false))
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: VH, position: Int) {
        val dataItem = list[position]
        holder.onBind(dataItem)
    }
    interface OnItemClickListener{
        fun onMyItemClick(dataItem: DataItem, position: Int)
        fun onMyLongItemClick(dataItem: DataItem)
    }
}
