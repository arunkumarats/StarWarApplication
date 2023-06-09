package com.assignment.starwarapplication.ui.main

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

    private lateinit var viewFavPeople: RecyclerView
    private lateinit var viewFavStarship: RecyclerView

    private var favPeopleListPerf = ArrayList<People?>()
    private var favStarshipListPerf = ArrayList<Vehicle?>()

    private lateinit var favoritePrefJson: String
    private lateinit var favoritePrefList: Type
    override fun onCreateView(

        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(
            R.layout.fragment_favorites, container, false
        )

        viewFavPeople = view?.findViewById(R.id.rv_favorite_chars)!!
        viewFavStarship = view.findViewById(R.id.rv_favorite_starships)!!
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
        below statements read string from shared-pref, convert string to json, covert json to arraylist
        and set arraylist to favorite people recycler view adapter
         */
        favoritePrefJson = AppPreferencesHelper(requireContext()).favoriteChars.toString()
        favoritePrefList = object : TypeToken<ArrayList<People?>?>() {}.type
        favPeopleListPerf = Gson().fromJson(favoritePrefJson, favoritePrefList)
        viewFavPeople.adapter = FavoritePeopleAdapter(favPeopleListPerf)

        /*
        STARSHIP
         below statements read string from shared-pref, convert string to json, covert json to arraylist
         and set arraylist to favorite starship recycler view adapter
        */
        favoritePrefJson = AppPreferencesHelper(requireContext()).favoriteStarships.toString()
        favoritePrefList = object : TypeToken<ArrayList<Vehicle?>?>() {}.type
        favStarshipListPerf = Gson().fromJson(favoritePrefJson, favoritePrefList)
        viewFavStarship.adapter = FavoriteStarshipAdapter(favStarshipListPerf)

    }
}