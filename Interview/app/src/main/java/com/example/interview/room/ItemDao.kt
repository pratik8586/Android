package com.example.interview.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Update

@Dao
interface ItemDao {

    @Query("select * from item where category_id=:categoryId")
    fun getAllItemsByCategory(categoryId: Int): List<Item>
}