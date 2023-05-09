package com.assignment.starwarapplication

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.lifecycle.ViewModelProvider
import androidx.viewpager.widget.ViewPager
import com.assignment.starwarapplication.ui.main.FavoriteFragment
import com.assignment.starwarapplication.ui.main.HomeFragment
import com.assignment.starwarapplication.ui.main.MainViewModel
import com.assignment.starwarapplication.utils.StarWarConstants
import com.google.android.material.tabs.TabLayout

/**
 * Starwar main activity
 *
 * Implementation for tab layout and view pager
 * This activity should stay as light as possible
 * Business logic can be added to respective MVVM classes
 *
 **/

class MainActivity : AppCompatActivity() {
    private lateinit var context: Context
    private var viewPagerAdapter: ViewPagerAdapter = ViewPagerAdapter(supportFragmentManager)
    lateinit var starwarActivityViewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        starwarActivityViewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        // Create the object of Toolbar, ViewPager and
        // TabLayout and use “findViewById()” method*/
        // var tab_toolbar = findViewById<Toolbar>(R.id.toolbar)
        var tab_viewpager = findViewById<ViewPager>(R.id.view_pager)
        var tab_tablayout = findViewById<TabLayout>(R.id.tabs)


        setupViewPager(tab_viewpager)

        // If we don't use setupWithViewPager() method then
        // tabs are not used or shown when activity opened
        tab_tablayout.setupWithViewPager(tab_viewpager)

    }

    // This function is used to add items in arraylist and assign
    // the adapter to view pager
    private fun setupViewPager(viewpager: ViewPager) {
        viewPagerAdapter = ViewPagerAdapter(supportFragmentManager)

        // LoginFragment is the name of Fragment and the Login
        // is a title of tab
        viewPagerAdapter.addFragment(HomeFragment(), StarWarConstants.HOME)
        viewPagerAdapter.addFragment(FavoriteFragment(), StarWarConstants.FAV)

        // setting adapter to view pager.
        viewpager.setAdapter(viewPagerAdapter)

        viewpager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {

            override fun onPageScrollStateChanged(state: Int) {
            }

            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {

            }

            override fun onPageSelected(position: Int) {
                viewpager.getAdapter()?.notifyDataSetChanged();
            }

        })
    }


      /*     This "ViewPagerAdapter" class overrides functions which are
     necessary to get information about which item is selected
     by user, what is title for Home and favorite*/
    class ViewPagerAdapter : FragmentPagerAdapter {

     /* One is of Fragment type and another one is of String type.*/
        private final var fragmentList1: ArrayList<Fragment> = ArrayList()
        private final var fragmentTitleList1: ArrayList<String> = ArrayList()

        public constructor(supportFragmentManager: FragmentManager)
                : super(supportFragmentManager)

        // returns item from list of fragments.
        override fun getItem(position: Int): Fragment {
            return fragmentList1.get(position)
        }

        override fun getItemPosition(`object`: Any): Int {
            return POSITION_NONE
        }

        // returns which item is selected from fragment titles.
        override fun getPageTitle(position: Int): CharSequence {
            return fragmentTitleList1.get(position)
        }

        // returns the number of items present in arraylist.
        override fun getCount(): Int {
            return fragmentList1.size
        }

        // function to adds the fragment and title from arraylist
        fun addFragment(fragment: Fragment, title: String) {
            fragmentList1.add(fragment)
            fragmentTitleList1.add(title)

        }
    }
}