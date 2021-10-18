package com.example.eval05_01.ui

import android.view.View
import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.example.eval05_01.databinding.ItemLayoutBinding
import com.example.eval05_01.local.PersonEntity

class Adapter(val dataList:ArrayList<PersonEntity>):RecyclerView.Adapter<Adapter.ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding :ViewDataBinding = Da
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        return dataList.size
    }
    class ViewHolder(private val view:View):RecyclerView.ViewHolder(view){
    }
}

