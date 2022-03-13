package com.example.hack.Adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.ViewCompat
import androidx.core.view.ViewPropertyAnimatorListener
import androidx.recyclerview.widget.RecyclerView
import com.example.hack.R
import com.example.hack.models.Helper
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import jp.wasabeef.recyclerview.animators.holder.AnimateViewHolder
import kotlinx.android.synthetic.main.inner_item.view.*
import java.lang.Exception

class HelperAdapter(var list: ArrayList<Helper>) :
    RecyclerView.Adapter<HelperAdapter.VH>(){

    class VH(view: View): RecyclerView.ViewHolder(view) {

        fun onBind(helper: Helper) {
            Picasso.get().load(helper.img).placeholder(R.drawable.place).into(itemView.img, object :
                Callback {
                override fun onSuccess() {

                }

                override fun onError(e: Exception?) {

                }
            })
            itemView.tv1.isSelected = true
            itemView.tv1.text = helper.title
            itemView.tv2.text = helper.description
        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH{
        return VH(LayoutInflater.from(parent.context).inflate(R.layout.help_item,parent,false))
    }

    override fun getItemCount(): Int = list.size


    override fun onBindViewHolder(holder: VH, position: Int) {
        val dataItem = list[position]
        holder.onBind(dataItem)

        holder.itemView.setOnClickListener {


        }


    }
    }