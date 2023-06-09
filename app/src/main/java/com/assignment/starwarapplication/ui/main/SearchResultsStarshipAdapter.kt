package com.assignment.starwarapplication.ui.main

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AlphaAnimation
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.assignment.starwarapplication.R
import com.assignment.starwarapplication.utils.StarWarConstants
import com.assignment.starwarapplication.data.local.prefs.AppPreferencesHelper
import com.assignment.starwarapplication.data.model.Vehicle
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlin.collections.ArrayList


/**
 * @author Arun
 *
 * Adapter class: Search results recycler adapter for starship
 * favorite button click functionalities goes here
 *
 */

class SearchResultsStarshipAdapter(private var searchResultVehicle: ArrayList<Vehicle?>): RecyclerView.Adapter<SearchResultsStarshipAdapter.ViewHolder>() {
    private var favStarshipList = ArrayList<Vehicle?>()
    private lateinit var favStarshipJsonString : String
    override fun getItemCount(): Int {
        return searchResultVehicle.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var vehicleData = searchResultVehicle[position]

        holder.txtShipname.text = vehicleData?.name
        holder.txtModel.text = StarWarConstants.MODEL + vehicleData?.model
        holder.txtManufacturer.text = StarWarConstants.MFGR + vehicleData?.manufacturer
        holder.txtPassenger.text = StarWarConstants.PSNGR + vehicleData?.passengers

        holder.btnFavStarship.setOnClickListener{
            Log.v("DEBUG : button clicked at position", vehicleData?.name.toString() )


            it.startAnimation(AlphaAnimation(1f, 0.8f))
            /**
             * Below logic to convert the String->Json-> Arraylist and vice versa
             * This is to reduce shared-pref overhead and keeps simple memory
             * SQLite db is an another option but not recommended to store simple starwar API data
             */
            favStarshipJsonString = AppPreferencesHelper(it.context).favoriteStarships.toString()
            val type = object : TypeToken<java.util.ArrayList<Vehicle?>?>() {}.getType()
            favStarshipList = Gson().fromJson(favStarshipJsonString, type)
            favStarshipList.add(vehicleData)
            favStarshipJsonString = Gson().toJson(favStarshipList)
            AppPreferencesHelper(it.context).favoriteStarships = favStarshipJsonString

        }

       }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.listitem_home_starships, parent, false)

        return ViewHolder(itemView)
    }

    // Method to clear current list-item and reload the updated recyclerview items
    fun submitList(newData: ArrayList<Vehicle?>) {
        searchResultVehicle.clear()
        searchResultVehicle.addAll(newData)
        notifyDataSetChanged() // necessary to refresh the recycler view
    }

    class ViewHolder(row: View) : RecyclerView.ViewHolder(row) {
        var txtShipname: TextView =  row.findViewById(R.id.tv_shipname)
        var txtModel: TextView = row.findViewById(R.id.tv_model)
        var txtManufacturer: TextView= row.findViewById(R.id.tv_manufacturer)
        var txtPassenger: TextView= row.findViewById(R.id.tv_passenger)
        var btnFavStarship : ImageButton= row.findViewById(R.id.button_fav_starship)

    }
}