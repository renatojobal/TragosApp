package com.renatojobal.tragosapp.data

import com.renatojobal.tragosapp.AppDatabase
import com.renatojobal.tragosapp.data.model.Drink
import com.renatojobal.tragosapp.domain.DataSource
import com.renatojobal.tragosapp.domain.TragosDao
import com.renatojobal.tragosapp.vo.Resource
import com.renatojobal.tragosapp.vo.RetrofitClient
import javax.inject.Inject

class DataSourceImpl @Inject constructor(private val tragoDao: TragosDao) :DataSource {


    override suspend fun getTragoBYName(tragoName: String): Resource<List<Drink>>{
        return Resource.Success(RetrofitClient.webservice.getTragoByName(tragoName).drinkList)
    }

    override suspend fun insertTragoIntoRoom(trago: Drink){
        tragoDao.insertFavorite(trago)
    }

    override suspend fun getTragosFromRoom(): Resource<List<Drink>> {
        return Resource.Success(tragoDao.getAllFavoriteDrinks())
    }

    override suspend fun deleteDrink(drink: Drink) {
        tragoDao.deleteDrink(drink)
    }


}