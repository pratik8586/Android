package com.example.interview.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.interview.R
import com.example.interview.room.Category

class HomeAdapter(private var list: List<Category>) :
    RecyclerView.Adapter<HomeAdapter.HomeViewHolder>() {

    //this method is returning the view for each item in the list
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.home_list_item, parent, false)
        return HomeViewHolder(v)
    }

    class HomeViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bindItems(category: Category) {
            val textViewName = itemView.findViewById(R.id.textView) as TextView
            textViewName.text = category.title
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