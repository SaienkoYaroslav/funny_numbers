package com.example.funnynumbers.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.funnynumbers.data.NumberApi
import com.example.funnynumbers.data.db.NumberDao
import com.example.funnynumbers.data.db.NumberEntity
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class NumberViewModel @Inject constructor(
    private val numberApi: NumberApi,
    private val numberDao: NumberDao
) : ViewModel() {

    val numbersList = numberDao.getAllNumbers()

    suspend fun insertNumber(number: Int) = viewModelScope.launch {
        withContext(Dispatchers.IO) {
            numberDao.insertNumber(getNumberById(number))
        }
    }

    suspend fun insertRandomNumber() = viewModelScope.launch {
        withContext(Dispatchers.IO) {
            numberDao.insertNumber(getRandomNumber())
        }
    }

    var detailNumber: NumberEntity? = null

    private suspend fun getNumberById(number: Int): NumberEntity =
        numberApi.getNumberById(number)

    private suspend fun getRandomNumber(): NumberEntity =
        numberApi.getRandomNumber()
}