package com.devsolutions.hygienehabitsapp.Core

import android.content.Context
import android.content.SharedPreferences

class Prefs(val context:Context) {
    val PREFS_NAME = "my_prefs"
    val SHARED_NAME = "shared_name"
    val SHARED_IS_LOGGED = "shared_is_logged"
    val prefs: SharedPreferences = context.getSharedPreferences(PREFS_NAME, 0)

    var isLogged:Boolean?
        get() = prefs.getBoolean(SHARED_IS_LOGGED, false)
        set(value) = prefs.edit().putBoolean(SHARED_IS_LOGGED, value!!).apply()

    var name: String?
        get() = prefs.getString(SHARED_NAME, "")
        set(value) = prefs.edit().putString(SHARED_NAME, value!!).apply()
}