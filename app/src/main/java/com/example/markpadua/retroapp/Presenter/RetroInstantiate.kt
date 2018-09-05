package com.example.markpadua.retroapp.Presenter

import com.example.markpadua.retroapp.Model.APIPlaces
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object RetroInstantiate {

    //url
    private const val ROOT_URL = "https://sampleapi2.herokuapp.com/"

    //instantiate
    private val retrofitInstance: Retrofit
        get() = Retrofit.Builder()
                .baseUrl(ROOT_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

    val retroInstantiate: APIPlaces
        get() = retrofitInstance.create<APIPlaces>(APIPlaces::class.java!!)
}
