package com.renatojobal.tragosapp.domain

import com.renatojobal.tragosapp.data.model.Drink
import com.renatojobal.tragosapp.data.model.DrinkList
import retrofit2.http.GET
import retrofit2.http.Query

interface WebService {

    @GET("search.php")
    suspend fun getTragoByName(@Query("s") tragoName: String) : DrinkList

}