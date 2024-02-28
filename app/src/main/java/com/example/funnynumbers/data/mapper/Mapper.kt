package com.example.funnynumbers.data.mapper

import com.example.funnynumbers.data.db.NumberEntity
import com.example.funnynumbers.domain.model.MyNumber

class Mapper {
    fun mapMyNumberToNumberEntity(myNumber: MyNumber) =
        NumberEntity(
            text = myNumber.text,
            found = myNumber.found,
            number = myNumber.number,
            type = myNumber.type,
            date = myNumber.date
        )
}

