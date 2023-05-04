package com.assignment.starwarapplication.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.assignment.starwarapplication.R

// Here ":" symbol is indicate that LoginFragment
// is child class of Fragment Class
class FavoriteFragment : Fragment() {

    lateinit var rv_fav_character: RecyclerView
    lateinit var rv_fav_starship: RecyclerView
    private var layoutManager: RecyclerView.LayoutManager? = null
    private var FavCharAdapter: RecyclerView.Adapter<FavoritePeopleAdapter.ViewHolder>? = null
    private var FavStarshipAdapter: RecyclerView.Adapter<FavoriteStarshipAdapter.ViewHolder>? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
       val view = inflater?.inflate(
            R.layout.fragment_favorites, container, false
        )

        rv_fav_character = view?.findViewById(R.id.rv_favorite_chars)!!
        rv_fav_starship = view?.findViewById(R.id.rv_favorite_starships)!!

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rv_fav_character.layoutManager = LinearLayoutManager(activity)
      //  FavCharAdapter = FavoritePeopleAdapter(msg)
        rv_fav_character.adapter = FavCharAdapter

        rv_fav_starship.layoutManager = LinearLayoutManager(activity)
      //  FavStarshipAdapter = FavoriteStarshipAdapter(msg)
        rv_fav_starship.adapter = FavCharAdapter
    }



}