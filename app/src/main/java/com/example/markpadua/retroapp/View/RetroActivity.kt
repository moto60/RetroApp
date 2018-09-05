package com.example.markpadua.retroapp.View

import android.app.ProgressDialog
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.example.markpadua.retroapp.R
import com.example.markpadua.retroapp.Contract.IRetroView
import com.example.markpadua.retroapp.Model.places
import android.content.Intent
import android.net.Uri
import com.example.markpadua.retroapp.Contract.IListListener
import com.example.markpadua.retroapp.Presenter.RetroPresenter

class RetroActivity : AppCompatActivity(), IRetroView, IListListener {

    private var loading: ProgressDialog? = null
    private var recyclerView: RecyclerView? = null
    private var eAdapter: placeAdapter? = null
    private lateinit var loginView : RetroPresenter



    override fun onNavClick(lat: String?, long: String?, name: String?) {

        val gmmIntentUri = Uri.parse("http://maps.google.com/maps?q=loc:$lat,$long($name)")
        val mapIntent = Intent(Intent.ACTION_VIEW, gmmIntentUri)
        mapIntent.setClassName("com.google.android.apps.maps","com.google.android.maps.MapsActivity")
        if (mapIntent.resolveActivity(packageManager) != null) {
            startActivity(mapIntent)
        }

    }


    override fun onCallClick(phone: String?) {

        val mintent = Intent(Intent.ACTION_DIAL);
        mintent.data = Uri.parse("tel:$phone")
        startActivity(mintent)

    }


    override fun onEmailClick(email: String?) {

        val emailIntent = Intent(Intent.ACTION_SENDTO)
        emailIntent.data = Uri.parse("mailto:$email")
        startActivity(emailIntent)

    }


    override fun onFailed() {

        loading?.dismiss()

    }


    override fun response(placelist1: ArrayList<places>?) {

        recyclerView = findViewById(R.id.recyclerView)
        eAdapter = placeAdapter(placelist1!!, this)
        val eLayoutManager = LinearLayoutManager(applicationContext)
        recyclerView?.layoutManager = eLayoutManager
        recyclerView?.itemAnimator = DefaultItemAnimator()
        recyclerView?.adapter = eAdapter
        eAdapter!!.notifyDataSetChanged()

    }


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_retro)
        loginView = RetroPresenter()
        loginView.setView(this)
        loginView.jsons()

    }


}
