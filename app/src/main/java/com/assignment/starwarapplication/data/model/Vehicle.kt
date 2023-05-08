package com.assignment.starwarapplication.data.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

/**
 * @author Arun
 * @see SwapAPI documentation
 * Vehicle model represents a single transport craft that does not have hyperdrive capability.
 */
data class Vehicle (
    var name: String? = null,
    var model: String? = null,

    @SerializedName("vehicle_class")
    var vehicleClass: String? = null,
    var manufacturer: String? = null,

    @SerializedName("cost_in_credits")
    var costInCredits: String? = null,
    var length: String? = null,
    var crew: String? = null,
    var passengers: String? = null,

    @SerializedName("max_atmosphering_speed")
    var maxAtmospheringSpeed: String? = null,

    @SerializedName("starship_class")
    var starshipClass: String? = null,

    @SerializedName("hyperdrive_rating")
    var hyperdriveRating: String? = null,

    @SerializedName("MGLT")
    var mglt: String? = null,

    @SerializedName("cargo_capacity")
    var cargoCapacity: String? = null,
    var consumables: String? = null,
    var created: String? = null,
    var edited: String? = null,
    var url: String? = null,

    @SerializedName("pilots")
    var pilotsUrls: ArrayList<String>? = null,

    @SerializedName("films")
    var filmsUrls: ArrayList<String>? = null
)