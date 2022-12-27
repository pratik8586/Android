package com.example.interview.room

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "category_table")
data class Category(
    @PrimaryKey(autoGenerate = false) val id: Int? = null,
    val title: String,
    val description: String,
    val priority: Int
)