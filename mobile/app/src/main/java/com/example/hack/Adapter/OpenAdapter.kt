package com.example.hack.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import androidx.core.view.ViewCompat
import androidx.core.view.ViewPropertyAnimatorListener
import androidx.recyclerview.widget.RecyclerView
import com.example.hack.R
import com.example.hack.models.DataItem
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import jp.wasabeef.recyclerview.animators.holder.AnimateViewHolder
import kotlinx.android.synthetic.main.inner_item.view.*
import java.lang.Exception

class OpenAdapter (var list:List<DataItem>, var onItemClickListener: OnItemClickListener) :
    RecyclerView.Adapter<OpenAdapter.VH>(){

    class VH(view: View): RecyclerView.ViewHolder(view), AnimateViewHolder {

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

        override fun preAnimateAddImpl(holder: RecyclerView.ViewHolder?) {
            ViewCompat.setTranslationY(itemView, -itemView.height * 0.3f)
            ViewCompat.setAlpha(itemView, 0f)
        }

        override fun preAnimateRemoveImpl(holder: RecyclerView.ViewHolder?) {

        }

        override fun animateAddImpl(
            holder: RecyclerView.ViewHolder?,
            listener: ViewPropertyAnimatorListener?
        ) {
            ViewCompat.animate(itemView).apply {
                translationY(0f)
                alpha(1f)
                duration = 3000
                setListener(listener)
            }.start()
        }

        override fun animateRemoveImpl(
            holder: RecyclerView.ViewHolder?,
            listener: ViewPropertyAnimatorListener?
        ) {
            ViewCompat.animate(itemView).apply {
                translationY(-itemView.height * 0.3f)
                alpha(0f)
                duration = 300
                setListener(listener)
            }.start()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH{
        return VH(LayoutInflater.from(parent.context).inflate(R.layout.open_item,parent,false))
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: VH, position: Int) {
        val dataItem = list[position]
        holder.onBind(dataItem)

        holder.itemView.setOnClickListener {
            onItemClickListener.onMyItemClick(dataItem, position)
        }

        holder.itemView.setOnLongClickListener(object: View.OnLongClickListener{
            override fun onLongClick(v: View?): Boolean {
                onItemClickListener.onMyLongItemClick(dataItem)
                return true
            }
        })
    }
    interface OnItemClickListener{
        fun onMyItemClick(dataItem: DataItem, position: Int)
        fun onMyLongItemClick(dataItem: DataItem)
    }
}