package com.assignment.starwarapplication.data.local.prefs

/**
 * @author  Arun
 */
interface PreferencesHelper {
    val favoriteChars: String?
    fun setFavoriteChar(people: String?)
    var favoriteStarship: String?
    fun setFavoriteStarship(starship: String?)
}