package com.assignment.starwarapplication.data.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

/**
 * Created by Oleur on 22/12/2014.
 * Species model represents a type of person or character within the Star Wars Universe.
 */
class Species : Serializable {
    var name: String? = null
    var classification: String? = null
    var designation: String? = null

    @SerializedName("average_height")
    var averageHeight: String? = null

    @SerializedName("average_lifespan")
    var averageLifespan: String? = null

    @SerializedName("eye_colors")
    var eyeColors: String? = null

    @SerializedName("hair_colors")
    var hairColors: String? = null

    @SerializedName("skin_colors")
    var skinColors: String? = null

    @SerializedName("homeworld")
    var homeWorld: String? = null
    var language: String? = null
    var created: String? = null
    var edited: String? = null
    var url: String? = null

    @SerializedName("people")
    var peopleUrls: ArrayList<String>? = null

    @SerializedName("films")
    var filmsUrls: ArrayList<String>? = null
}