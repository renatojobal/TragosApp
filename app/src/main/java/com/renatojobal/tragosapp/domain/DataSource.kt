package com.renatojobal.tragosapp.domain

import com.renatojobal.tragosapp.data.model.Drink
import com.renatojobal.tragosapp.vo.Resource
import com.renatojobal.tragosapp.vo.RetrofitClient

interface DataSource {
    suspend fun getTragoBYName(tragoName: String): Resource<List<Drink>>

    suspend fun insertTragoIntoRoom(trago: Drink)

    suspend fun getTragosFromRoom(): Resource<List<Drink>>

    suspend fun deleteDrink(drink: Drink)
}