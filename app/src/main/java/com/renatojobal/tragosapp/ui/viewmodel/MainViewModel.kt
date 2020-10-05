package com.renatojobal.tragosapp.ui.viewmodel

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import com.renatojobal.tragosapp.data.model.Drink
import com.renatojobal.tragosapp.domain.Repo
import com.renatojobal.tragosapp.vo.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.lang.Exception
import javax.inject.Inject

class MainViewModel @ViewModelInject constructor (private val repo:Repo):ViewModel() {

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


    fun guardarTrago(trago: Drink){
        viewModelScope.launch {
            repo.insertTrago(trago)
        }
    }

    fun getTragosFavoritos() = liveData(Dispatchers.IO) {
        emit(Resource.Loading())
        try {
            emit(repo.getTragosFavoritos())
        }catch (e: Exception){
            emit(Resource.Failure(e))
        }
    }

    fun deleteTrago(drink: Drink) {
        viewModelScope.launch {
            repo.deleteDrink(drink)
        }
    }


}