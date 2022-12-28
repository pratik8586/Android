package com.example.interview.room

import androidx.annotation.NonNull
import androidx.annotation.Nullable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "category")
data class Category(
    @PrimaryKey(autoGenerate = false)
    val id: Int? = null,
    @NonNull
    val title: String,
    val description: String? = null,
    val priority: Int? = null
)