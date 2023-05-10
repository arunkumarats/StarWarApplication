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
import com.assignment.starwarapplication.data.model.Vehicle
import com.google.android.material.switchmaterial.SwitchMaterial

/**
 * @author Arun
 * Home module fragment
 *
*/
class HomeFragment : Fragment() {
    private lateinit var searchView: SearchView
    private  lateinit var progressView: ProgressBar
    private lateinit var searchResultRecyclerView: RecyclerView
    private lateinit var searchFilterToggle: SwitchMaterial
    private lateinit var mainActivityViewModel: MainViewModel
    private var searchListPeople = ArrayList<People?>()
    private var searchListStarship = ArrayList<Vehicle?>()

    private var searchResultCharAdapter: RecyclerView.Adapter<SearchResultsCharacterAdapter.ViewHolder>? = null
    private var searchResultStarshipAdapter: RecyclerView.Adapter<SearchResultsStarshipAdapter.ViewHolder>? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        val view = inflater.inflate(
            R.layout.fragment_home,
            container, false
        )
        mainActivityViewModel = ViewModelProvider(this)[MainViewModel::class.java]
        searchView = view.findViewById(R.id.sv_search_bar)!!
        progressView = view.findViewById(R.id.progressbar_home)!!
        searchResultRecyclerView = view.findViewById(R.id.rv_charactersview)!!
        searchFilterToggle = view.findViewById(R.id.switch_searchfilter)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        searchResultRecyclerView.layoutManager = LinearLayoutManager(activity)

        searchFilterToggle.setOnCheckedChangeListener { compoundButton, isChecked ->

            Log.v("DEBUG", "Toggle: $isChecked")
            if(isChecked){
                searchFilterToggle.text = "Show results in Starship"
            }else{
                searchFilterToggle.text = "Show results in Starwar character"
            }


        }


        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {


                return false
            }

            override fun onQueryTextChange(query: String): Boolean {

                if (query.length > 1) {
                    searchFilterToggle.isEnabled = true

                    progressView.visibility = View.VISIBLE

                    if(searchFilterToggle.isChecked){
                        mainActivityViewModel.getStarship(query)
                            .observe(viewLifecycleOwner, Observer { serviceSetterGetter ->

                                progressView.visibility = View.GONE
                                searchResultStarshipAdapter = SearchResultsStarshipAdapter(searchListStarship)
                                searchResultRecyclerView.adapter = searchResultStarshipAdapter
                                (searchResultStarshipAdapter as SearchResultsStarshipAdapter).submitList(serviceSetterGetter?.results!!)
                                (searchResultStarshipAdapter as SearchResultsStarshipAdapter).notifyDataSetChanged()
                            })
                    }else{

                        mainActivityViewModel.getPeople(query)
                            .observe(viewLifecycleOwner, Observer { serviceSetterGetter ->

                                progressView.visibility = View.GONE
                                searchResultCharAdapter = SearchResultsCharacterAdapter(searchListPeople)
                                searchResultRecyclerView.adapter = searchResultCharAdapter
                                (searchResultCharAdapter as SearchResultsCharacterAdapter).submitList(serviceSetterGetter?.results!!)
                                (searchResultCharAdapter as SearchResultsCharacterAdapter).notifyDataSetChanged()
                            })



                    }
                }
                else{
                    searchFilterToggle.isEnabled = false
                }
                return false
            }
        })
    }

}