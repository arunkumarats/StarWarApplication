package com.assignment.starwarapplication.ui.main

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.assignment.starwarapplication.R
import com.assignment.starwarapplication.data.local.prefs.AppPreferencesHelper
import com.assignment.starwarapplication.data.model.People
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlin.collections.ArrayList


/**
 * @author Arun
 *
 * Adapter class for Search results
 */

class SearchResultsAdapter(private var searchResultList: ArrayList<People?>): RecyclerView.Adapter<SearchResultsAdapter.ViewHolder>() {
    private var fav_list = ArrayList<People?>()
    override fun getItemCount(): Int {
        return searchResultList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var peopleData = searchResultList[position]
        holder?.txt_name?.text = peopleData?.name
        holder?.txt_gender?.text = "Gender: "+peopleData?.gender
        holder?.txt_ships?.text = "Number of ships: "+peopleData?.starshipsUrls?.size.toString()

        holder?.btn_fav?.setOnClickListener{
            Log.v("DEBUG : button clicked at position", peopleData?.name.toString() )

            var json: String = AppPreferencesHelper(it.context).getFavoriteChars()
            val type = object : TypeToken<java.util.ArrayList<People?>?>() {}.getType()
            fav_list = Gson().fromJson(json, type)
            fav_list.add(peopleData)
            json = Gson().toJson(fav_list)

            AppPreferencesHelper(it.context).setFavoriteChar(json)

        }

       }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent?.context)
            .inflate(R.layout.listitem_home_characters, parent, false)

        return ViewHolder(itemView)
    }

    fun submitList(newData: ArrayList<People?>) {
        searchResultList.clear()
        searchResultList.addAll(newData)
        notifyDataSetChanged()
    }

    class ViewHolder(row: View) : RecyclerView.ViewHolder(row) {
        var txt_name: TextView? = null
        var txt_gender: TextView? = null
        var txt_ships: TextView?= null
        var btn_fav : ImageButton?= null

        init {
            this.txt_name = row?.findViewById<TextView>(R.id.tv_name)
            this.txt_gender = row?.findViewById<TextView>(R.id.tv_gender)
            this.txt_ships = row?.findViewById<TextView>(R.id.tv_ships)
            this.btn_fav = row?.findViewById<ImageButton>(R.id.button)


        }


    }
}