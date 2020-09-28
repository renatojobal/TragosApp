package com.renatojobal.tragosapp.domain

import com.renatojobal.tragosapp.data.model.Drink
import com.renatojobal.tragosapp.vo.Resource

interface Repo {
    fun getTragosList(): Resource<List<Drink>>

}