package com.assignment.starwarapplication.data.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

/**
 * Created by Oleur on 22/12/2014.
 * Starship model represents a single transport craft that has hyperdrive capability.
 */

class Starship : Vehicle(), Serializable {
    @SerializedName("starship_class")
    var starshipClass: String? = null

    @SerializedName("hyperdrive_rating")
    var hyperdriveRating: String? = null

    @SerializedName("MGLT")
    var mglt: String? = null
}