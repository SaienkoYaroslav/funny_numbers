package com.example.funnynumbers.domain.repository

import com.example.funnynumbers.domain.model.MyNumber
import kotlinx.coroutines.flow.Flow

interface RepositoryNumber {

    suspend fun getListNumbers(): Flow<List<MyNumber>>

}