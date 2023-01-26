package com.devsolutions.hygienehabitsapp.Core

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitHelper {
    val URL_BASE = "https://hygienehabitsback-production.up.railway.app/api/hygienehabits/"
    val URL_BASE_LOCAL = "http://192.168.219.21:3000/api/hygienehabits/"
    fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(URL_BASE_LOCAL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}