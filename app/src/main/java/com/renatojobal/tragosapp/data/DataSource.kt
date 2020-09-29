package com.renatojobal.tragosapp.data

import com.renatojobal.tragosapp.data.model.Drink
import com.renatojobal.tragosapp.vo.Resource
import com.renatojobal.tragosapp.vo.RetrofitClient

class DataSource {

    suspend fun getTragoBYName(tragoName: String): Resource<List<Drink>>{
        return Resource.Success(RetrofitClient.webservice.getTragoByName(tragoName).drinkList)
    }




}