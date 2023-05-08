package com.assignment.starwarapplication.ui.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.assignment.starwarapplication.R
import com.assignment.starwarapplication.data.model.People
import com.assignment.starwarapplication.utils.SWUtils


/**
 *@author Arun
 */

class FavoritePeopleAdapter(private var items: ArrayList<People?>): RecyclerView.Adapter<FavoritePeopleAdapter.ViewHolder>() {
    private var fav_list = ArrayList<People?>()

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var peopleData = items[position]
        var filmstring : String = ""
        holder?.txtFavName?.text = peopleData?.name
        holder?.txtFavGender?.text = "Gender: "+peopleData?.gender
        holder?.txtFavShips?.text = "Number of ships: "+peopleData?.starshipsUrls?.size.toString()


        //Below loop is recommended by SWAPI API spec to get the name of the film from the film url
        for (i in peopleData?.filmsUrls?.indices!!) {
            filmstring = filmstring + "\n"+ SWUtils.filmUrlToFilmTitle(peopleData?.filmsUrls?.get(i).toString())!!
        }

          holder?.txtFavFilms?.text = filmstring
      //  Log.v("DEBUG" ,  +"")
       }
    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getItemViewType(position: Int): Int {
        return position
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
        var txtFavName: TextView = row.findViewById(R.id.tv_fav_name)
        var txtFavGender: TextView = row.findViewById(R.id.tv_fav_gender)
        var txtFavShips: TextView= row.findViewById(R.id.tv_fav_ships)
        var txtFavFilms: TextView= row.findViewById(R.id.tv_fav_films)
    }
}