package com.example.funnynumbers.data.db

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [NumberEntity::class],
    version = 1,
    exportSchema = false
)
abstract class Database : RoomDatabase() {

    abstract fun numbersDao(): NumberDao

}