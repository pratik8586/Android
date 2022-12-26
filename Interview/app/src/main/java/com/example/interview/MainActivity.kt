package com.example.interview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.interview.adapter.HomeAdapter

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        //getting recyclerview from xml
        val recyclerView = findViewById(R.id.recycler) as RecyclerView

        //adding a layoutmanager
        recyclerView.layoutManager = GridLayoutManager(this,2)

        //crating an arraylist to store users using the data class user
        val users = ArrayList<String>()

        //adding some dummy data to the list
        users.add("Human Resources (HR)")
        users.add("Software Engineering")
        users.add("Civil services")
        users.add("Finance")
        users.add("Human Resources (HR)")
        users.add("Software Engineering")
        users.add("Civil services")
        users.add("Finance")

        //creating our adapter
        val adapter = HomeAdapter(users)

        //now adding the adapter to recyclerview
        recyclerView.adapter = adapter

    }
}