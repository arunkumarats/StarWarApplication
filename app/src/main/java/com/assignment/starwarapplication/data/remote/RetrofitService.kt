package com.assignment.starwarapplication.data.remote

import android.util.Log
import com.assignment.starwarapplication.APIConstants
import com.assignment.starwarapplication.BuildConfig
import com.assignment.starwarapplication.data.model.*
import retrofit2.Callback
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import okhttp3.logging.HttpLoggingInterceptor.Level
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

interface RetrofitService {
    @GET("/")
    fun getRootUrls(callback: Callback<Root?>?)

    @GET("/people/")
    fun getAllPeople(
        @Query("page") page: Int,
        callback: Callback<SWModelList<People?>?>?
    )

/*
    @GET("/people/{id}/")
    fun getPeople(@Path("id") peopleId: Int,callback: Callback<People?>?)
*/

    @GET("/api/people/")
    fun getPeople(@Query("search") query: String) : Call<SWModelList<People?>?>


    @GET("/api/starships/")
    fun getStarship(@Query("search") query: String) : Call<SWModelList<Vehicle?>?>



    @GET("/films/")
    fun getAllFilms(
        @Query("page") page: Int,
        callback: Callback<SWModelList<Film?>?>?
    )

    @GET("/films/{id}/")
    fun getFilm(
        @Path("id") filmId: Int,
        callback: Callback<Film?>?
    )
/*
    @GET("/starships")
    fun getAllStarships(
        @Query("page") page: Int,
        callback: Callback<SWModelList<Starship?>?>?
    )*/

/*
    @GET("/starships/{id}/")
    fun getStarship(
        @Path("id") starshipId: Int,
        callback: Callback<Starship?>?
    )
*/

    @GET("/vehicles/")
    fun getAllVehicles(
        @Query("page") page: Int,
        callback: Callback<SWModelList<Vehicle?>?>?
    )

    @GET("/vehicles/{id}/")
    fun getVehicle(
        @Path("id") vehicleId: Int,
        callback: Callback<Vehicle?>?
    )

    @GET("/species/")
    fun getAllSpecies(
        @Query("page") page: Int,
        callback: Callback<SWModelList<Species?>?>?
    )

    @GET("/species/{id}/")
    fun getSpecies(
        @Path("id") speciesId: Int,
        callback: Callback<Species?>?
    )

    @GET("/planets/")
    fun getAllPlanets(
        @Query("page") page: Int,
        callback: Callback<SWModelList<Planet?>?>?
    )

    @GET("/planets/{id}/")
    fun getPlanet(
        @Path("id") planetId: Int,
        callback: Callback<Planet?>?
    )

    object RetrofitClient {
        val retrofitClient: Retrofit.Builder by lazy {

            val levelType: Level
            if (BuildConfig.BUILD_TYPE.contentEquals("debug"))
                levelType = Level.BODY else levelType = Level.NONE

            val logging = HttpLoggingInterceptor()
            logging.setLevel(levelType)

            val okhttpClient = OkHttpClient.Builder()
            okhttpClient.addInterceptor(logging)

            Retrofit.Builder()
                .baseUrl(APIConstants.BASE_URL)
                .client(okhttpClient.build())
                .addConverterFactory(GsonConverterFactory.create())
        }

        val apiInterface: RetrofitService by lazy {
            retrofitClient
                .build()
                .create(RetrofitService::class.java)
        }
    }

}