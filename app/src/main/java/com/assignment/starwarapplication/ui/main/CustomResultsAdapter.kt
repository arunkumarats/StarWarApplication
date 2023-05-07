package com.assignment.starwarapplication.ui.main

import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.recyclerview.widget.RecyclerView
import com.assignment.starwarapplication.R
import com.assignment.starwarapplication.data.model.People
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import kotlin.collections.ArrayList


/**
 * Created by bett on 8/26/17.
 */

class CustomResultsAdapter(private var items: ArrayList<People?>): RecyclerView.Adapter<CustomResultsAdapter.ViewHolder>() {
    private var fav_list = ArrayList<People?>()
    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var peopleData = items[position]
        holder?.txt_name?.text = peopleData?.name
        holder?.txt_gender?.text = "Gender: "+peopleData?.gender
        holder?.txt_ships?.text = "Number of ships: "+peopleData?.starshipsUrls?.size.toString()

        holder?.btn_fav?.setOnClickListener{
            Log.v("DEBUG : button clicked at position", peopleData?.name.toString() )

         /*   val sharedPreferences = it.context.getSharedPreferences("starwar_pref", MODE_PRIVATE)
            val gson = Gson()
            val json = sharedPreferences.getString("fav_people_list", "")
            val type = object: TypeToken<ArrayList<People>>() {
            }.type*/
           // fav_list = gson.fromJson(json, type)


            val prefs: SharedPreferences = it.context.getSharedPreferences("starwar_pref", MODE_PRIVATE)
            val gson = Gson()
            var json: String = prefs.getString("fav_people_list", "[]").toString()
            val type = object : TypeToken<java.util.ArrayList<People?>?>() {}.getType()
            fav_list = gson.fromJson(json, type)
            fav_list.add(peopleData)
            json = gson.toJson(fav_list)
            val editor: SharedPreferences.Editor = prefs.edit()
            editor.putString("fav_people_list", json)
            editor.apply()



        /*    val sharedPreferences = it.context.getSharedPreferences("starwar_pref", MODE_PRIVATE)
            val editor = sharedPreferences.edit()
            val gson = Gson()

            val gson1 = GsonBuilder().create()
            val theList = gson1.fromJson<ArrayList<People?>>("fav_list", object :TypeToken<ArrayList<People?>>(){}.type)
            theList.add(peopleData)
            val json = gson.toJson(theList)
            editor.putString("fav_list", json)
            editor.apply()*/
        }

       }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent?.context)
            .inflate(R.layout.listitem_home_characters, parent, false)

        return ViewHolder(itemView)
    }

    fun submitList(newData: ArrayList<People?>) {
        items.clear()
        items.addAll(newData)
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