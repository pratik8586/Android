package com.example.interview

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.interview.adapter.HomeAdapter
import com.example.interview.adapter.ItemAdapter
import com.example.interview.room.InterviewDatabase
import com.example.interview.room.ItemDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ItemActivity : AppCompatActivity() {
    private lateinit var itemDao: ItemDao
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.item_activity)
        Log.i("MyTAG", " ====== TEST ======")
        val bundle: Bundle? = intent.extras

        var itemId: Int = 0
        bundle?.let {

            bundle.apply {

                itemId = intent.getIntExtra("ID", 0)
                Log.i("MyTAG", "id ============ ${itemId}")
            }
        }


        val recyclerView = findViewById(R.id.item_recycler) as RecyclerView
        //adding a layoutmanager
        recyclerView.layoutManager = LinearLayoutManager(this)
        //get Db instance
        itemDao = InterviewDatabase.getInstance(this).itemDao()
        // fetch and set data to adapter
        lifecycleScope.launch(Dispatchers.IO) {
            //Query
            val categoryList = itemDao.getAllItemsByCategory(itemId)
            //creating our adapter
            val adapter = ItemAdapter(categoryList)

            //now adding the adapter to recyclerview
            recyclerView.adapter = adapter
        }


    }


    private fun showToast(
        context: Context = applicationContext,
        message: String,
        duration: Int = Toast.LENGTH_SHORT
    ) {
        if (!message.contains("null"))
            Toast.makeText(context, message, duration).show()
    }
}