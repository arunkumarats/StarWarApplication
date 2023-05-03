package com.assignment.starwarapplication.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.assignment.starwarapplication.data.model.Film
import com.assignment.starwarapplication.data.model.People
import com.assignment.starwarapplication.data.model.SWModelList
import com.assignment.starwarapplication.data.model.Starship
import com.assignment.starwarapplication.repository.MainActivityRepository

class MainViewModel() : ViewModel() {

    lateinit var characterList: MutableLiveData<SWModelList<People?>?>
    val starshipList = MutableLiveData<Starship>()
    val filmList = MutableLiveData<Film>()

    val errorMessage = MutableLiveData<String>()

        fun getPeople(query: String) : LiveData<SWModelList<People?>?> {
            characterList = MainActivityRepository.getPeopleApiCall(query)
            return characterList
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
/*
    val text: LiveData<String> = Transformations.map(_index) {
        "Hello world from section: $it"
    }
*/

    fun setIndex(index: Int) {
        _index.value = index
    }
}