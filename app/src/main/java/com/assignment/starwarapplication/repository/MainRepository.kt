package com.assignment.starwarapplication.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.assignment.starwarapplication.data.model.People
import com.assignment.starwarapplication.data.model.SWModelList
import com.assignment.starwarapplication.data.model.Vehicle
import com.assignment.starwarapplication.data.remote.RetrofitService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * @author Arun
 * Repository class for Character and Vehicle API
 * future use case API calls- success/failure response can be handled here
 */
object MainActivityRepository {

    val peopleSetterGetter = MutableLiveData<SWModelList<People?>?>()
    val vehicleSetterGetter = MutableLiveData<SWModelList<Vehicle?>?>()

    /**
     * Character API call handling
     * @param Query: Search string
     * @return Arraylist of characters
     */
    fun getPeopleApiCall(query: String): MutableLiveData<SWModelList<People?>?> {

        val call = RetrofitService.RetrofitClient.apiInterface.getPeople(query)

        call.enqueue(object : Callback<SWModelList<People?>?> {
            override fun onFailure(call: Call<SWModelList<People?>?>, t: Throwable) {
                Log.v("DEBUG : ", t.message.toString())
            }

            override fun onResponse(
                call: Call<SWModelList<People?>?>,
                response: Response<SWModelList<People?>?>
            ) {
                Log.v("DEBUG : Response >>> ", response.body().toString())

                peopleSetterGetter.postValue(response.body())
            }
        })

        return peopleSetterGetter
    }



    /**
     * Starships API call handling
     * @param Query: Search string
     * @return Arraylist of starships
     */
    fun getStarshipApiCall(query: String): MutableLiveData<SWModelList<Vehicle?>?> {

        val call = RetrofitService.RetrofitClient.apiInterface.getStarship(query)

        call.enqueue(object : Callback<SWModelList<Vehicle?>?> {
            override fun onFailure(call: Call<SWModelList<Vehicle?>?>, t: Throwable) {
                Log.v("DEBUG : ", t.message.toString())
            }

            override fun onResponse(
                call: Call<SWModelList<Vehicle?>?>,
                response: Response<SWModelList<Vehicle?>?>
            ) {
                Log.v("DEBUG : Response >>> ", response.body().toString())

                vehicleSetterGetter.postValue(response.body())

            }
        })

        return vehicleSetterGetter
    }
}
