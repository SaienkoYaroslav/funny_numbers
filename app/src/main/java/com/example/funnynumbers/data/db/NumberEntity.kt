package com.example.funnynumbers.data.db

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "numbers_table")
data class NumberEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,
    val text: String,
    val found: Boolean,
    val number: Int,
    val type: String,
    val date: String
)