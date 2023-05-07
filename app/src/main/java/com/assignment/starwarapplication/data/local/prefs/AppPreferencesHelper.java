package com.assignment.starwarapplication.data.local.prefs;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * @author Arun
 * <p>
 * Starwar Preference helper class and methods
 */

public class AppPreferencesHelper implements PreferencesHelper {
    private static final String PREF_KEY_FAV_CHAR = "PREF_KEY_FAV_CHAR";

    private static final String PREF_KEY_FAV_STARSHIP = "PREF_KEY_FAV_STARSHIP";

    private final SharedPreferences mStarwarPrefs;

    public AppPreferencesHelper(Context context) {
        mStarwarPrefs = context.getSharedPreferences("starwar_pref", Context.MODE_PRIVATE);
    }

    @Override
    public String getFavoriteChars() {
        return mStarwarPrefs.getString(PREF_KEY_FAV_CHAR, "[]");
    }

    @Override
    public void setFavoriteChar(String people) {
        mStarwarPrefs.edit().putString(PREF_KEY_FAV_CHAR, people).apply();
    }

    @Override
    public String getFavoriteStarship() {
        return mStarwarPrefs.getString(PREF_KEY_FAV_STARSHIP, "[]");
    }

    @Override
    public void setFavoriteStarship(String starship) {
        mStarwarPrefs.edit().putString(PREF_KEY_FAV_STARSHIP, starship).apply();
    }


}
