package com.assignment.starwarapplication.data.model

import com.google.gson.annotations.SerializedName

data class Movie(
    @SerializedName("Title") val title: String,
    @SerializedName("Poster") val poster: String,
    val imdbID: String,
    @SerializedName("Year") val year: String
)
