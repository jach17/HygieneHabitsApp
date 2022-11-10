package com.devsolutions.hygienehabitsapp.Core

import android.content.Context
import android.content.SharedPreferences

class Prefs(context:Context) {
    val PREFS_NAME = "com.cursokotlin.sharedpreferences"
    val SHARED_NAME = "shared_name"
    val prefs: SharedPreferences = context.getSharedPreferences(PREFS_NAME, 0)
    var name: String?
        get() = prefs.getString(SHARED_NAME, "")
        set(value) = prefs.edit().putString(SHARED_NAME, value).apply()



}