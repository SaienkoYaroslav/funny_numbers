package com.example.funnynumbers.ui

import androidx.lifecycle.ViewModel
import com.example.funnynumbers.data.NumberApi
import com.example.funnynumbers.data.db.NumberDao
import com.example.funnynumbers.domain.model.MyNumber
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class NumberViewModel @Inject constructor(
    private val numberApi: NumberApi,
    private val numberDao: NumberDao
): ViewModel() {

    val numbersList = numberDao.getAllNumbers()

    suspend fun getNumberById(number: Int): MyNumber =
        numberApi.getNumberById(number)

    suspend fun getRandomNumber(): MyNumber =
        numberApi.getRandomNumber()
}