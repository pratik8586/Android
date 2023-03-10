package com.example.interview.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Update

@Dao
interface CategoryDao {

    //    @Query("select * from home_table order by priority desc")
    @Query("select * from category")
    fun getAllCategories(): List<Category>

    @Insert
    suspend fun insertCategory(book: Category)

    @Update
    suspend fun updateBook(book: Category)

    @Delete
    suspend fun deleteBook(book: Category)


    @Transaction
    @Query("SELECT * FROM category")
    fun getCategoryItems(): List<CategoryItem>
}