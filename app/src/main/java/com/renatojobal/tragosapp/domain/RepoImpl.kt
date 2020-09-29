package com.renatojobal.tragosapp.domain

import com.renatojobal.tragosapp.data.DataSource
import com.renatojobal.tragosapp.data.model.Drink
import com.renatojobal.tragosapp.vo.Resource

class RepoImpl(private val dataSource: DataSource): Repo {

    override fun getTragosList(): Resource<List<Drink>> {
        return dataSource.generateTragosList
    }

}