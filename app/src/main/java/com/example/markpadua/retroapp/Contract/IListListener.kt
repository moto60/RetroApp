package com.example.markpadua.retroapp.Contract

interface IListListener{
    fun onNavClick(lat: String?,long: String?,name:String?)
    fun onCallClick(phone:String?)
    fun onEmailClick(email: String?)
}