package com.example.markpadua.retroapp.Contract

import android.support.v7.widget.RecyclerView
import com.example.markpadua.retroapp.Model.places
import com.example.markpadua.retroapp.Model.PlaceList
import com.example.markpadua.retroapp.View.placeAdapter
import retrofit2.Response

interface IRetroView{
    fun response(placeList:ArrayList<places>?)
    fun onFailed()
}