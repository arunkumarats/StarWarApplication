package com.assignment.starwarapplication.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.assignment.starwarapplication.R

// Here ":" symbol is indicate that LoginFragment
// is child class of Fragment Class
class FavoriteFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(
            R.layout.fragment_favorites, container, false
        )
    }
    // Here "layout_login" is a name of layout file
    // created for LoginFragment
}