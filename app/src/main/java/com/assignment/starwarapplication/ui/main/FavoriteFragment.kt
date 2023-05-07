package com.assignment.starwarapplication.ui.main

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.assignment.starwarapplication.R
import com.assignment.starwarapplication.data.local.prefs.AppPreferencesHelper
import com.assignment.starwarapplication.data.model.People
import com.assignment.starwarapplication.data.model.Vehicle
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type

/**
 *  @author Arun
 *
 *  Favorite Module's main fragment
 *  fragment to populate favorite character and favorite starship which is marked from search results
 */
class FavoriteFragment : Fragment() {

    private var layoutManager: RecyclerView.LayoutManager? = null

    lateinit var viewFavPeople: RecyclerView
    lateinit var viewFavStarship: RecyclerView

    private var favPeopleListPerf = ArrayList<People?>()
    private var favStarshipListPerf = ArrayList<Vehicle?>()

    lateinit private var favoritePrefJson: String
    lateinit private var favoritePrefList: Type
    override fun onCreateView(

        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        val view = inflater?.inflate(
            R.layout.fragment_favorites, container, false
        )

        viewFavPeople = view?.findViewById(R.id.rv_favorite_chars)!!
        viewFavStarship = view?.findViewById(R.id.rv_favorite_starships)!!
        viewFavPeople.layoutManager =
            LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
        viewFavStarship.layoutManager =
            LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        /*
        CHARACTER(PEOPLE)
        below statements read string from sharedpref, convert string to json, covert json to arraylist
        and set arraylist to favorite people recyler view adapter
         */
        favoritePrefJson = AppPreferencesHelper(requireContext()).getFavoriteChars()
       // favoritePrefJson = prefs.getString("fav_people_list", "[]").toString()
        favoritePrefList = object : TypeToken<ArrayList<People?>?>() {}.getType()
        favPeopleListPerf = Gson().fromJson(favoritePrefJson, favoritePrefList)
        viewFavPeople.adapter = FavoritePeopleAdapter(favPeopleListPerf)

        /*
        STARSHIP
         below statements read string from sharedpref, convert string to json, covert json to arraylist
         and set arraylist to favorite starship recyler view adapter
        */
        favoritePrefJson =AppPreferencesHelper(requireContext()).getFavoriteStarship()
        favoritePrefList = object : TypeToken<ArrayList<Vehicle?>?>() {}.getType()
        favStarshipListPerf = Gson().fromJson(favoritePrefJson, favoritePrefList)
        viewFavStarship.adapter = FavoriteStarshipAdapter(favStarshipListPerf)

    }
}