package com.renatojobal.tragosapp.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.renatojobal.tragosapp.domain.Repo
import com.renatojobal.tragosapp.vo.Resource
import kotlinx.coroutines.Dispatchers
import java.lang.Exception

class MainViewModel(private val repo:Repo):ViewModel() {

    val fetchTragosList = liveData(Dispatchers.IO) {
        emit(Resource.Loading())
        try {
            emit(repo.getTragosList("margarita"))
        }catch (e: Exception){
            emit(Resource.Failure(e))
        }

    }
}