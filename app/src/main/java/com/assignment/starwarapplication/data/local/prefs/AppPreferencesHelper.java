/*
 *  Copyright (C) 2017 MINDORKS NEXTGEN PRIVATE LIMITED
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      https://mindorks.com/license/apache-v2
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License
 */

package com.assignment.starwarapplication.data.local.prefs;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by amitshekhar on 07/07/17.
 */

public class AppPreferencesHelper implements PreferencesHelper {
        private static final String PREF_KEY_FAV_CHAR = "PREF_KEY_FAV_CHAR";

    private static final String PREF_KEY_FAV_STARSHIP = "PREF_KEY_FAV_STARSHIP";

    private final SharedPreferences mPrefs;

    public AppPreferencesHelper(Context context, String prefFileName) {
        mPrefs = context.getSharedPreferences(prefFileName, Context.MODE_PRIVATE);
    }

    @Override
    public String getFavoriteChars() {
        return mPrefs.getString(PREF_KEY_FAV_CHAR, null);
    }

    @Override
    public void setFavoriteChar(String people) {
        mPrefs.edit().putString(PREF_KEY_FAV_CHAR, people).apply();
    }

    @Override
    public String getFavoriteStarship() {
        return mPrefs.getString(PREF_KEY_FAV_STARSHIP, null);
    }

    @Override
    public void setFavoriteStarship(String starship) {
        mPrefs.edit().putString(PREF_KEY_FAV_STARSHIP, starship).apply();
    }



}
