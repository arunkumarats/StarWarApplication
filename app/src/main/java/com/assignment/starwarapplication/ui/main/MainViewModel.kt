package com.assignment.starwarapplication.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.assignment.starwarapplication.data.model.People
import com.assignment.starwarapplication.data.model.Vehicle
import com.assignment.starwarapplication.data.model.SWModelList
import com.assignment.starwarapplication.repository.MainActivityRepository

/**
 * @author Arun
 * ViewModal class for Character and startship API
 * Interface between repository and API response, returns Livedata
 */
class MainViewModel() : ViewModel() {

    lateinit var characterList: MutableLiveData<SWModelList<People?>?>
    lateinit var starshipList: MutableLiveData<SWModelList<Vehicle?>?>

    /**
     *  Viewmodel for starwar character API call
     */
    fun getPeople(query: String): LiveData<SWModelList<People?>?> {
        characterList = MainActivityRepository.getPeopleApiCall(query)

        return characterList
    }

    /**
     * Viewmodel for starwar Starship API call
     */
    fun getStarship(query: String): LiveData<SWModelList<Vehicle?>?> {
        starshipList = MainActivityRepository.getStarshipApiCall(query)

        return starshipList
    }

}