package com.example.eval05_01.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.eval05_01.R
import com.example.eval05_01.local.PersonEntity
import kotlinx.android.synthetic.main.item_layout.view.*

class Adapter(private val dataList:ArrayList<PersonEntity>):RecyclerView.Adapter<Adapter.ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = dataList[position]
        holder.setData(item)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun setData(item: PersonEntity) {
            itemView.apply {
                Glide.with(iv_img).load(item.img_url).into(iv_img)
                tv_country.text = item.country
                tv_dob.text = item.dob
                tv_dod.text = item.dod
            }
        }
    }
}

