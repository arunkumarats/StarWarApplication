package com.assignment.starwarapplication.data.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

/**
 * @author Arun
 * @see SwapAPI documentation
 * Root model that provides information on all avaiable resources within the API.
 */
class Root : Serializable {
    @SerializedName("films")
    var filmsUrl: String? = null

    @SerializedName("people")
    var peopleUrl: String? = null

    @SerializedName("planets")
    var planetsUrl: String? = null

    @SerializedName("species")
    var speciesUrl: String? = null

    @SerializedName("starships")
    var starshipsUrl: String? = null

    @SerializedName("vehicles")
    var vehiclesUrl: String? = null
}