package com.assignment.starwarapplication.utils;

import android.text.TextUtils;


import com.assignment.starwarapplication.data.model.People;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by Oleur on 24/12/2014.
 * Utility class for Star Wars API
 */
public class SWUtils {

    public enum SORT {
        ASC,
        DESC
    }

    public static int compare(int lhs, int rhs) {
        return lhs < rhs ? -1 : (lhs == rhs ? 0 : 1);
    }


    public static String filmUrlToFilmTitle(String filmUrl) {
        int filmId;
        try {
            filmId = filmUrl.charAt(filmUrl.length()-2);
        } catch (Exception e) {
            return null;
        }
        switch (filmId) {
            case 1:
                return "Star Wars Episode IV A New Hope";
            case 2:
                return "Star Wars Episode V The Empire Strikes Back";
            case 3:
                return "Star Wars Episode VI Return of the Jedi";
            case 4:
                return "Star Wars Episode I The Phantom Menace";
            case 5:
                return "Star Wars Episode II Attack of the Clones";
            case 6:
                return "Star Wars Episode III Revenge of the Sith";
            default:
                return null;
        }
    }
}
