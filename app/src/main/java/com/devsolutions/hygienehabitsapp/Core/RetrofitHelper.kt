package com.devsolutions.hygienehabitsapp.Core

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitHelper {
    val URL_BASE = "https://hygienehabitsback-production.up.railway.app/api/hygienehabits/"
    val URL_BASE_LOCAL = "https://192.168.0.107:3000/api/hygienehabits/"
    fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(URL_BASE)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}