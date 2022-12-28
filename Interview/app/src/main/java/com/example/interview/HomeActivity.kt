package com.example.interview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.interview.adapter.HomeAdapter
import com.example.interview.room.Category
import com.example.interview.room.CategoryDao
import com.example.interview.room.InterviewDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class HomeActivity : AppCompatActivity() {

    private lateinit var categoryDao:CategoryDao

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //getting recyclerview from xml
        val recyclerView = findViewById(R.id.recycler) as RecyclerView
        //adding a layoutmanager
        recyclerView.layoutManager = GridLayoutManager(this,2)
        //get Db instance
        categoryDao = InterviewDatabase.getInstance(this).homeDao()
        // fetch and set data to adapter
        testDB(recyclerView);
    }

    private  fun testDB(recyclerView: RecyclerView) {


            lifecycleScope.launch (Dispatchers.IO) {
                //Insert
//                Log.i("MyTAG", "*****     Inserting 3 Books     **********")
//                categoryDao.insertCategory(Category(3, "Java", "Alex",0))
//                categoryDao.insertCategory(Category(4, "PHP", "Mike",1))
//                categoryDao.insertCategory(Category(5, "Kotlin", "Amelia",2))
//                Log.i("MyTAG", "*****     Inserted 3 categories       **********")

                //Query
                val categoryList = categoryDao.getAllCategories()
                Log.i("MyTAG", "*****   ${categoryList.size} books there *****")
                for (cat in categoryList) {
                    Log.i("MyTAG", "id: ${cat.id} name: ${cat.title}")
                }
                //creating our adapter
                val adapter = HomeAdapter(categoryList)

                //now adding the adapter to recyclerview
                recyclerView.adapter = adapter

//                //Update
//                Log.i("MyTAG", "*****      Updating a book      **********")
//                homeDao.updateBook(Home(1, "PHPUpdated", "Mike"))
//                //Query
//                val books2 = homeDao.getAllBooks()
//                Log.i("MyTAG", "*****   ${books2.size} books there *****")
//                for (book in books2) {
//                    Log.i("MyTAG", "id: ${book.id} name: ${book.name} author: ${book.author}")
//                }
//
//                //delete
//                Log.i("MyTAG", "*****       Deleting a book      **********")
//                homeDao.deleteBook(Home(2, "Kotlin", "Amelia"))
//                //Query
//                val books3 = homeDao.getAllBooks()
//                Log.i("MyTAG", "*****   ${books3.size} books there *****")
//                for (book in books3) {
//                    Log.i("MyTAG", "id: ${book.id} name: ${book.name} author: ${book.author}")
//                }
            }
        }

}