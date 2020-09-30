package com.renatojobal.tragosapp.data

import com.renatojobal.tragosapp.AppDatabase
import com.renatojobal.tragosapp.data.model.Drink
import com.renatojobal.tragosapp.domain.DataSource
import com.renatojobal.tragosapp.vo.Resource
import com.renatojobal.tragosapp.vo.RetrofitClient

class DataSourceImpl(private val appDatabase: AppDatabase) :DataSource {

    override suspend fun getTragoBYName(tragoName: String): Resource<List<Drink>>{
        return Resource.Success(RetrofitClient.webservice.getTragoByName(tragoName).drinkList)
    }

    override suspend fun insertTragoIntoRoom(trago: Drink){
        appDatabase.tragoDao().insertFavorite(trago)
    }

    override suspend fun getTragosFromRoom(): Resource<List<Drink>> {
        return Resource.Success(appDatabase.tragoDao().getAllFavoriteDrinks())
    }

    override suspend fun deleteDrink(drink: Drink) {
        appDatabase.tragoDao().deleteDrink(drink)
    }


}