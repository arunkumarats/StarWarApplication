package com.assignment.starwarapplication.data.local.prefs

import android.content.Context
import android.content.SharedPreferences

/**
 * @author Arun
 *
 *
 * Starwar Preference helper class and methods
 */
class AppPreferencesHelper(context: Context) : PreferencesHelper {
    private val mStarwarPrefs: SharedPreferences

    init {
        mStarwarPrefs = context.getSharedPreferences("starwar_pref", Context.MODE_PRIVATE)
    }

    override var favoriteChars: String?
        get() = mStarwarPrefs.getString(PREF_KEY_FAV_CHAR, "[]")
        set(favoriteChars) {
            mStarwarPrefs.edit().putString(PREF_KEY_FAV_CHAR, favoriteChars).apply()
        }


    override var favoriteStarships: String?
        get() = mStarwarPrefs.getString(PREF_KEY_FAV_STARSHIP, "[]")
        set(favoriteStarships) {
            mStarwarPrefs.edit().putString(PREF_KEY_FAV_STARSHIP, favoriteStarships).apply()
        }

    companion object {
        private const val PREF_KEY_FAV_CHAR = "PREF_KEY_FAV_CHAR"
        private const val PREF_KEY_FAV_STARSHIP = "PREF_KEY_FAV_STARSHIP"
    }
}