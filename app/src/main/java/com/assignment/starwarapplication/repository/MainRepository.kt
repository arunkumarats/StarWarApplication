
package com.assignment.starwarapplication.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.assignment.starwarapplication.data.model.People
import com.assignment.starwarapplication.data.model.SWModelList
import com.assignment.starwarapplication.data.remote.RetrofitService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object MainActivityRepository {

    val peopleSetterGetter = MutableLiveData<SWModelList<People?>?>()

    fun getPeopleApiCall(query: String): MutableLiveData<SWModelList<People?>?> {

        val call = RetrofitService.RetrofitClient.apiInterface.getPeopletest(query)

        call.enqueue(object: Callback<SWModelList<People?>?>

        {
            override fun onFailure(call: Call<SWModelList<People?>?>, t: Throwable) {
                // TODO("Not yet implemented")
                Log.v("DEBUG : ", t.message.toString())
            }

            override fun onResponse(
                call: Call<SWModelList<People?>?>,
                response: Response<SWModelList<People?>?>
            ) {

                // TODO("Not yet implemented")
                Log.v("DEBUG : 123 @@@@@@@@@", response.body().toString())

             peopleSetterGetter.postValue(response.body())

              //   val msg = data!!.count
             //   peopleSetterGetter.value = People(msg)
            }
        })

        return peopleSetterGetter
    }
}
