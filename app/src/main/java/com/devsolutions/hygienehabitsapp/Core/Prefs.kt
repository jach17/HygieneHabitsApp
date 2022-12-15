package com.devsolutions.hygienehabitsapp.Core

import android.content.Context
import android.content.SharedPreferences

class Prefs(val context:Context) {
    val PREFS_NAME = "my_prefs"
    val SHARED_ID = "shared_id"
    val SHARED_IS_LOGGED = "shared_is_logged"
    val SHARED_TOKEN = "shared_token"
    val prefs: SharedPreferences = context.getSharedPreferences(PREFS_NAME, 0)

    var isLogged:Boolean?
        get() = prefs.getBoolean(SHARED_IS_LOGGED, false)
        set(value) = prefs.edit().putBoolean(SHARED_IS_LOGGED, value!!).apply()

    var tutorId:Int?
        get() = prefs.getInt(SHARED_ID, 0)
        set(value) = prefs.edit().putInt(SHARED_ID, value!!).apply()

    var tutorToken:String?
        get() = prefs.getString(SHARED_TOKEN, "")
        set(value) = prefs.edit().putString(SHARED_TOKEN, value!!).apply()

}