package com.assignment.starwarapplication.data.model

import android.text.TextUtils
import java.io.Serializable

/**
 * @author Arun Kumar Thayalan
 * @see SwapAPI documentation
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