package com.example.markpadua.retroapp.Model

import com.example.markpadua.retroapp.Model.PlaceList
import retrofit2.Call
import retrofit2.http.GET
import io.reactivex.Observable


interface APIPlaces {

    @GET("https://sampleapi2.herokuapp.com/getplaces?location=manila")
    fun myJSON():Observable<PlaceList>
}