package com.renatojobal.tragosapp.domain

import com.renatojobal.tragosapp.data.DataSourceImpl
import com.renatojobal.tragosapp.data.model.Drink
import com.renatojobal.tragosapp.vo.Resource

class RepoImpl(private val dataSource: DataSourceImpl): Repo {

    override suspend fun getTragosList(tragoName: String): Resource<List<Drink>> {
        return dataSource.getTragoBYName(tragoName)
    }

    override suspend fun getTragosFavoritos(): Resource<List<Drink>> {
        return dataSource.getTragosFromRoom()
    }

    override suspend fun insertTrago(trago: Drink) {
        dataSource.insertTragoIntoRoom(trago)
    }

    override suspend fun deleteDrink(drink: Drink) {
        dataSource.deleteDrink(drink)
    }

}