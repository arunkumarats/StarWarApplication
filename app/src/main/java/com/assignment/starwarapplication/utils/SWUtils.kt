package com.assignment.starwarapplication.utils

/**
 * Created by Oleur on 24/12/2014.
 * Utility class for Star Wars API
 */
object SWUtils {
    fun compare(lhs: Int, rhs: Int): Int {
        return if (lhs < rhs) -1 else if (lhs == rhs) 0 else 1
    }

    fun filmUrlToFilmTitle(filmUrl: String): String? {
        val filmId :Char
        filmId = try { filmUrl.get(filmUrl.length-2)

          //  filmUrl[filmUrl.length - 1].code
        } catch (e: Exception) {
            return null
        }
        return when (filmId) {
            '1' -> "Star Wars Episode IV A New Hope"
            '2' -> "Star Wars Episode V The Empire Strikes Back"
            '3' -> "Star Wars Episode VI Return of the Jedi"
            '4' -> "Star Wars Episode I The Phantom Menace"
            '5' -> "Star Wars Episode II Attack of the Clones"
            '6' -> "Star Wars Episode III Revenge of the Sith"
            else -> null
        }
    }

    enum class SORT {
        ASC, DESC
    }
}