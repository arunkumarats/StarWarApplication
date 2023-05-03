package com.assignment.starwarapplication.data.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

/**
 * Created by Oleur on 21/12/2014.
 * Film model represents a Star Wars single film.
 */

data class Film(
    @SerializedName("title")
    var title: String? = null,

    @SerializedName("episode_id")
    var episodeId: Int = 0,

    @SerializedName("opening_crawl")
    var openingCrawl: String? = null,

    var director: String? = null,
    var producer: String? = null,
    var url: String? = null,
    var created: String? = null,
    var edited: String? = null,

    @SerializedName("species")
    var speciesUrls: ArrayList<String>? = null,

    @SerializedName("starships")
    var starshipsUrls: ArrayList<String>? = null,

    @SerializedName("vehicles")
    var vehiclesUrls: ArrayList<String>? = null,

    @SerializedName("planets")
    var planetsUrls: ArrayList<String>? = null,

    @SerializedName("characters")
    var charactersUrls: ArrayList<String>? = null
)