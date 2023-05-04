package com.assignment.starwarapplication.ui.main

import android.content.Context.MODE_PRIVATE
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.assignment.starwarapplication.R
import com.assignment.starwarapplication.data.model.People
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlin.collections.ArrayList


/**
 * Created by bett on 8/26/17.
 */

class FavoritePeopleAdapter(private var items: ArrayList<People?>): RecyclerView.Adapter<FavoritePeopleAdapter.ViewHolder>() {
    private var fav_list = ArrayList<People?>()
    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var peopleData = items[position]
        holder?.txt_fav_name?.text = peopleData?.name
        holder?.txt_fav_gender?.text = "Gender: "+peopleData?.gender
        holder?.txt_fav_ships?.text = "Number of ships: "+peopleData?.starshipsUrls?.size.toString()

       }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent?.context)
            .inflate(R.layout.listitem_favorite_characters, parent, false)

        return ViewHolder(itemView)
    }

    fun submitList(newData: ArrayList<People?>) {
        items.clear()
        items.addAll(newData)
        notifyDataSetChanged()
    }

    class ViewHolder(row: View) : RecyclerView.ViewHolder(row) {
        var txt_fav_name: TextView? = null
        var txt_fav_gender: TextView? = null
        var txt_fav_ships: TextView?= null
        init {
            this.txt_fav_name = row?.findViewById<TextView>(R.id.tv_fav_name)
            this.txt_fav_gender = row?.findViewById<TextView>(R.id.tv_fav_gender)
            this.txt_fav_ships = row?.findViewById<TextView>(R.id.tv_fav_ships)

        }


    }
}