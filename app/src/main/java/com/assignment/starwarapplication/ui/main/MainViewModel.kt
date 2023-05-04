package com.assignment.starwarapplication.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.assignment.starwarapplication.data.model.*
import com.assignment.starwarapplication.repository.MainActivityRepository

class MainViewModel() : ViewModel() {

    lateinit var characterList: MutableLiveData<SWModelList<People?>?>
    lateinit var starshipList: MutableLiveData<SWModelList<Vehicle?>?>

    val errorMessage = MutableLiveData<String>()

        fun getPeople(query: String) : LiveData<SWModelList<People?>?> {
            characterList = MainActivityRepository.getPeopleApiCall(query)
            return characterList
        }

    fun getStarship(query: String) : LiveData<SWModelList<Vehicle?>?> {
        starshipList = MainActivityRepository.getStarshipApiCall(query)
        return starshipList
    }

/*    fun getStarships() {

        val response = repository.getStarships()
        response.enqueue(object : Callback<Starship> {
            override fun onResponse(call: Call<Starship>, response: Response<Starship>) {
                starshipList.postValue(response.body())
            }

            override fun onFailure(call: Call<Starship>, t: Throwable) {
                errorMessage.postValue(t.message)
            }

        })

    }


    fun getFilms() {

        val response = repository.getFilms()
        response.enqueue(object : Callback<Film> {
            override fun onResponse(call: Call<Film>, response: Response<Film>) {
                filmList.postValue(response.body())
            }

            override fun onFailure(call: Call<Film>, t: Throwable) {
                errorMessage.postValue(t.message)
            }

        })

    }*/


    private val _index = MutableLiveData<Int>()
    fun setIndex(index: Int) {
        _index.value = index
    }
}