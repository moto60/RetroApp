package com.example.markpadua.retroapp.Model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class PlaceList {

    @SerializedName("places")
    @Expose
    var places : List<places>? =null
}