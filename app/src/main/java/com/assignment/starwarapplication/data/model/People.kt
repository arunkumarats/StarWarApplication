package com.assignment.starwarapplication.data.model


import com.google.gson.annotations.SerializedName
import java.io.Serializable

/**
 * Created by Oleur on 21/12/2014.
 * People model represents an individual person or character within the Star Wars universe.
 */
data class People (
    val name: String? = null,

    @SerializedName("birth_year")
    var birthYear: String? = null,
    var gender: String? = null,

    @SerializedName("hair_color")
    var hairColor: String? = null,
    var height: String? = null,

    @SerializedName("homeworld")
    var homeWorldUrl: String? = null,
    var mass: String? = null,

    @SerializedName("skin_color")
    var skinColor: String? = null,
    var created: String? = null,
    var edited: String? = null,
    var url: String? = null,

    @SerializedName("films")
    var filmsUrls: ArrayList<String>? = null,

    @SerializedName("species")
    var speciesUrls: ArrayList<String>? = null,

    @SerializedName("starships")
    var starshipsUrls: ArrayList<String>? = null,

    @SerializedName("vehicles")
    var vehiclesUrls: ArrayList<String>? = null
)