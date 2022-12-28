package com.example.interview.room

import androidx.room.Embedded
import androidx.room.Relation

data class CategoryItem(
    @Embedded val category: Category,
    @Relation(
         parentColumn = "id",
         entityColumn = "category_id"
    )
    val item: Item
)