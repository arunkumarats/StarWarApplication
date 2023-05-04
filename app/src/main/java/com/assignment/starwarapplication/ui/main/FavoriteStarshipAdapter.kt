package com.assignment.starwarapplication.ui.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.assignment.starwarapplication.R
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
        holder?.txt_fav_name?.text = starShipData?.name
        holder?.txt_fav_model?.text = "Model: " + starShipData?.model
        holder?.txt_fav_manufacturer?.text = "Manufacturer: " + starShipData?.manufacturer
        holder?.txt_fav_passenger?.text = "Passengers: " + starShipData?.passengers
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent?.context)
            .inflate(R.layout.listitem_favorite_starships, parent, false)
        return ViewHolder(itemView)
    }

    fun submitList(newData: ArrayList<Vehicle?>) {
        items.clear()
        items.addAll(newData)
        notifyDataSetChanged()
    }

    class ViewHolder(row: View) : RecyclerView.ViewHolder(row) {
        var txt_fav_name: TextView? = null
        var txt_fav_model: TextView? = null
        var txt_fav_manufacturer: TextView? = null
        var txt_fav_passenger: TextView? = null

        init {
            this.txt_fav_name = row?.findViewById<TextView>(R.id.tv_fav_shipname)
            this.txt_fav_model = row?.findViewById<TextView>(R.id.tv_fav_model)
            this.txt_fav_manufacturer = row?.findViewById<TextView>(R.id.tv_fav_manufacturer)
            this.txt_fav_passenger = row?.findViewById<TextView>(R.id.tv_fav_passenger)
        }
    }
}