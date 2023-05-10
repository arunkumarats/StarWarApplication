package com.assignment.starwarapplication.ui.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.assignment.starwarapplication.R
import com.assignment.starwarapplication.utils.StarWarConstants
import com.assignment.starwarapplication.data.model.Vehicle

/**
 * @author Arun Kumar Thayalan
 * This adapter to populate the favorite starship from persist storage
 **/


class FavoriteStarshipAdapter(private var items: ArrayList<Vehicle?>) :
    RecyclerView.Adapter<FavoriteStarshipAdapter.ViewHolder>() {
    private var fav_list = ArrayList<Vehicle?>()
    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var starShipData = items[position]
        holder.txtFavName.text = starShipData?.name
        holder.txtFavModel.text = StarWarConstants.MODEL + starShipData?.model
        holder.txtFavManufacturer.text = StarWarConstants.MFGR + starShipData?.manufacturer
        holder.txtFavPassenger.text = StarWarConstants.PSNGR + starShipData?.passengers
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent?.context)
            .inflate(R.layout.listitem_favorite_starships, parent, false)
        return ViewHolder(itemView)
    }

    class ViewHolder(row: View) : RecyclerView.ViewHolder(row) {
        var txtFavName: TextView = row.findViewById(R.id.tv_fav_shipname)
        var txtFavModel: TextView =  row.findViewById(R.id.tv_fav_model)
        var txtFavManufacturer: TextView = row.findViewById(R.id.tv_fav_manufacturer)
        var txtFavPassenger: TextView = row.findViewById(R.id.tv_fav_passenger)

    }
}