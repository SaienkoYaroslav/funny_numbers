package com.example.funnynumbers.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface NumberDao {

    @Insert
    fun insertNumber(numberEntity: NumberEntity)

    @Query("SELECT * FROM numbers_table")
    fun getAllNumbers(): Flow<List<NumberEntity>>

}