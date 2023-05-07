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
    private var favItem = ArrayList<People?>()
    override fun getItemCount(): Int {
        return searchResultList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var peopleData = searchResultList[position]
        holder.txtName?.text = peopleData?.name
        holder.txtGender?.text = "Gender: "+peopleData?.gender
        holder.txtShips?.text = "Number of ships: "+peopleData?.starshipsUrls?.size.toString()

        holder.btnFav?.setOnClickListener{
            Log.v("DEBUG : button clicked at position", peopleData?.name.toString() )

            var json: String = AppPreferencesHelper(it.context).favoriteChars
            val type = object : TypeToken<java.util.ArrayList<People?>?>() {}.getType()
            favItem = Gson().fromJson(json, type)
            favItem.add(peopleData)
            json = Gson().toJson(favItem)

            AppPreferencesHelper(it.context).setFavoriteChar(json)

        }

       }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.listitem_home_characters, parent, false)

        return ViewHolder(itemView)
    }

    fun submitList(newData: ArrayList<People?>) {
        searchResultList.clear()
        searchResultList.addAll(newData)
        notifyDataSetChanged()
    }

    class ViewHolder(row: View) : RecyclerView.ViewHolder(row) {
        var txtName: TextView =  row.findViewById(R.id.tv_name)
        var txtGender: TextView? = row.findViewById(R.id.tv_gender)
        var txtShips: TextView?= row.findViewById(R.id.tv_ships)
        var btnFav : ImageButton?= row.findViewById(R.id.button)

    }
}