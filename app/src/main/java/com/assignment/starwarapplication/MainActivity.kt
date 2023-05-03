package com.assignment.starwarapplication

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.viewpager.widget.ViewPager
import com.assignment.starwarapplication.data.model.People
import com.assignment.starwarapplication.ui.main.FavoriteFragment
import com.assignment.starwarapplication.ui.main.HomeFragment
import com.assignment.starwarapplication.ui.main.MainViewModel
import com.google.android.material.tabs.TabLayout
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {
    lateinit var context: Context
    private var fav_list = ArrayList<People>()

    lateinit var mainActivityViewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mainActivityViewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        // Create the object of Toolbar, ViewPager and
        // TabLayout and use “findViewById()” method*/
       // var tab_toolbar = findViewById<Toolbar>(R.id.toolbar)
        var tab_viewpager = findViewById<ViewPager>(R.id.view_pager)
        var tab_tablayout = findViewById<TabLayout>(R.id.tabs)

        // As we set NoActionBar as theme to this activity
        // so when we run this project then this activity doesn't
        // show title. And for this reason, we need to run
        // setSupportActionBar method
      //  setSupportActionBar(tab_toolbar)
        setupViewPager(tab_viewpager)

        // If we dont use setupWithViewPager() method then
        // tabs are not used or shown when activity opened
        tab_tablayout.setupWithViewPager(tab_viewpager)
    /*    mainActivityViewModel.getPeople("da")!!.observe(this, Observer { serviceSetterGetter ->


            var msg = serviceSetterGetter.toString()

            if (msg != null) {
                Log.v("arun",msg)
            }

        })*/

    }

    // This function is used to add items in arraylist and assign
    // the adapter to view pager
    private fun setupViewPager(viewpager: ViewPager) {
        var adapter: ViewPagerAdapter = ViewPagerAdapter(supportFragmentManager)

        // LoginFragment is the name of Fragment and the Login
        // is a title of tab
        adapter.addFragment(HomeFragment(), "Home")
        adapter.addFragment(FavoriteFragment(), "Favorites")

        // setting adapter to view pager.
        viewpager.setAdapter(adapter)
    }


 /*   public fun saveData() {
        val sharedPreferences = getSharedPreferences("shared preferences", MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        val gson = Gson()
        val json = gson.toJson(fav_list)
        editor.putString("task list", json)
        editor.apply()
    }

    public fun loadData() {
        val sharedPreferences = getSharedPreferences("starwar_prefs", MODE_PRIVATE)
        val gson = Gson()
        val json = sharedPreferences.getString("fav_people_list", "")
        val type = object: TypeToken<ArrayList<People>>() {
        }.type
            fav_list = gson.fromJson(json, type)
    }*/



    // This "ViewPagerAdapter" class overrides functions which are
    // necessary to get information about which item is selected
    // by user, what is title for selected item and so on.*/
    class ViewPagerAdapter : FragmentPagerAdapter {

        // objects of arraylist. One is of Fragment type and
        // another one is of String type.*/
        private final var fragmentList1: ArrayList<Fragment> = ArrayList()
        private final var fragmentTitleList1: ArrayList<String> = ArrayList()

        // this is a secondary constructor of ViewPagerAdapter class.
        public constructor(supportFragmentManager: FragmentManager)
                : super(supportFragmentManager)

        // returns which item is selected from arraylist of fragments.
        override fun getItem(position: Int): Fragment {
            return fragmentList1.get(position)
        }

        // returns which item is selected from arraylist of titles.
        override fun getPageTitle(position: Int): CharSequence {
            return fragmentTitleList1.get(position)
        }

        // returns the number of items present in arraylist.
        override fun getCount(): Int {
            return fragmentList1.size
        }

        // this function adds the fragment and title in 2 separate  arraylist.
        fun addFragment(fragment: Fragment, title: String) {
            fragmentList1.add(fragment)
            fragmentTitleList1.add(title)

        }
    }
}