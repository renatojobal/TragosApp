package com.renatojobal.tragosapp.domain

import com.renatojobal.tragosapp.data.model.Drink
import com.renatojobal.tragosapp.vo.Resource

interface Repo {
    suspend fun getTragosList(tragoName: String): Resource<List<Drink>>

}