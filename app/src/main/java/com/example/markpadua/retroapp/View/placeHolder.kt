package com.example.markpadua.retroapp.View

import android.content.Intent
import android.net.Uri
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.markpadua.retroapp.Model.places
import com.example.markpadua.retroapp.R
import kotlinx.android.synthetic.main.list_layout.view.*
import com.example.markpadua.retroapp.Contract.IListListener


class placeHolder(view: View) : RecyclerView.ViewHolder(view){


    var img: ImageView
    var place: TextView

    init{

        img = view.findViewById(R.id.imgPlaces)
        place = view.findViewById(R.id.txtPlaces)


    }

    fun BindData(places: List<places>, placesposition: Int, listener: IListListener){


        val places = places[placesposition]
        itemView.btnNavigate.setOnClickListener{
            listener.onNavClick(places.lat,places.long,places.name)
        }
        itemView.btnCall.setOnClickListener {
            listener.onCallClick(places.phone)
        }
        itemView.btnEmail.setOnClickListener {
            listener.onEmailClick(places.email)
        }
        place.setText(places.name)
        Glide.with(itemView.context)
                .load(places.photo)
                .into(img!!)

    }
}