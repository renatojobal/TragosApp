package com.renatojobal.tragosapp.ui.viewmodel

import androidx.lifecycle.*
import com.renatojobal.tragosapp.domain.Repo
import com.renatojobal.tragosapp.vo.Resource
import kotlinx.coroutines.Dispatchers
import java.lang.Exception

class MainViewModel(private val repo:Repo):ViewModel() {

    private val tragosData = MutableLiveData<String>()

    fun setTrago(tragoName: String){
        tragosData.value = tragoName
    }

    init {
        setTrago("margarita")
    }

    val fetchTragosList = tragosData.distinctUntilChanged().switchMap {
        liveData(Dispatchers.IO) {
            emit(Resource.Loading())
            try {
                emit(repo.getTragosList(it))
            }catch (e: Exception){
                emit(Resource.Failure(e))
            }
    }

    }



}