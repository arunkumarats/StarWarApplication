package com.assignment.starwarapplication.ui.main

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.assignment.starwarapplication.R
import com.assignment.starwarapplication.data.model.People
import com.google.gson.Gson

/*
@author Arun Kumar Thayalan
*/
class HomeFragment : Fragment() {
    lateinit var searchView: SearchView
    lateinit var progressView: ProgressBar
    lateinit var rv_charactersView: RecyclerView
    lateinit var mainActivityViewModel: MainViewModel
    var msg = ArrayList<People?>()
    private var layoutManager: RecyclerView.LayoutManager? = null
    private var customadapter: RecyclerView.Adapter<CustomResultsAdapter.ViewHolder>? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater?.inflate(
            R.layout.fragment_home,
            container, false
        )
        mainActivityViewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        searchView = view?.findViewById(R.id.sv_search_bar)!!
        progressView = view?.findViewById(R.id.progressbar_home)!!
        rv_charactersView = view?.findViewById(R.id.rv_charactersview)!!

        return view
    }


    private fun saveData(fav_list: ArrayList<People?>) {
        val sharedPreferences = requireContext().getSharedPreferences("starwar_prefs", 0)
        val editor = sharedPreferences.edit()
        val gson = Gson()
        val json = gson.toJson(fav_list)
        editor.putString("fav_people_list", json)
        editor.apply()
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rv_charactersView.layoutManager = LinearLayoutManager(activity)
        customadapter = CustomResultsAdapter(msg)
        rv_charactersView.adapter = customadapter


        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {


                return false
            }

            override fun onQueryTextChange(query: String): Boolean {

                if (query.length > 2) {
                    progressView.visibility = View.VISIBLE
                    mainActivityViewModel.getPeople(query)!!
                        .observe(viewLifecycleOwner, Observer { serviceSetterGetter ->

                            progressView.visibility = View.GONE
                            (customadapter as CustomResultsAdapter).submitList(serviceSetterGetter?.results!!)
                            (customadapter as CustomResultsAdapter).notifyDataSetChanged()
                        })

                    Log.v("arun", "query entered")
                }
                return false
            }
        })
    }

}