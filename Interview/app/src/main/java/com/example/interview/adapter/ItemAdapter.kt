package com.example.interview.adapter

import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.interview.CONSTANTS
import com.example.interview.HomeActivity
import com.example.interview.ItemActivity
import com.example.interview.R
import com.example.interview.room.Category
import com.example.interview.room.Item

class ItemAdapter(private var list: List<Item>) :
    RecyclerView.Adapter<ItemAdapter.HomeViewHolder>() {

    //this method is returning the view for each item in the list
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_item_list, parent, false)
        return HomeViewHolder(v)
    }

    class HomeViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bindItems(item: Item) {
            val textViewName = itemView.findViewById(R.id.item_description) as TextView
            textViewName.text = item.description
        }

    }

    //this method is binding the data on the list
    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        holder.bindItems(list[position])
    }

    //this method is giving the size of the list
    override fun getItemCount(): Int {
        return list.size
    }
}