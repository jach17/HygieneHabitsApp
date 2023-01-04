package com.devsolutions.hygienehabitsapp.Core

import android.app.Application

class SharedApp :Application() {
    companion object {
        lateinit var prefs: Prefs
    }
    override fun onCreate() {
        super.onCreate()
        prefs = Prefs(applicationContext)
    }
}