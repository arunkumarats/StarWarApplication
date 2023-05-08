package com.assignment.starwarapplication.data.model

import com.google.gson.annotations.SerializedName

/**
 * @author Arun
 * @see SwapAPI documentation
 */
data class MovieList(

    @SerializedName("Search") val mList: List<Movie>

    )
