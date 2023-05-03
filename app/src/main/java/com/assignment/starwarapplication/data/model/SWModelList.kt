package com.assignment.starwarapplication.data.model

import android.text.TextUtils
import java.io.Serializable

/**
 * Created by Oleur on 22/12/2014.
 * Generic list model
 */
class SWModelList<T> : Serializable {
    var count = 0
    var next: String? = null
    var previous: String? = null
    var results: ArrayList<T>? = null
    fun hasMore(): Boolean {
        return !TextUtils.isEmpty(next)
    }
}