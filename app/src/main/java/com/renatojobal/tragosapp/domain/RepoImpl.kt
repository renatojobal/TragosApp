package com.renatojobal.tragosapp.domain

import com.renatojobal.tragosapp.data.DataSource
import com.renatojobal.tragosapp.data.model.Drink
import com.renatojobal.tragosapp.vo.Resource

class RepoImpl(private val dataSource: DataSource): Repo {

    override suspend fun getTragosList(tragoName: String): Resource<List<Drink>> {
        return dataSource.getTragoBYName(tragoName)
    }

}