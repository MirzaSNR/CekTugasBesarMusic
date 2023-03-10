package com.example.tugasbesarmusic

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_tracklist.*
//cek
class TrackList : AppCompatActivity(), ImageAdapterTracklist.OnItemClickListener {

    lateinit var tracklistRV: RecyclerView
    lateinit var imageAdapterTracklist: ImageAdapterTracklist
    lateinit var tracklistList: ArrayList<TracklistAttribute>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tracklist)

        back_tracklist()
//

        tracklistRV = findViewById(R.id.idRVTracklist)

        tracklistList = ArrayList()

        imageAdapterTracklist = ImageAdapterTracklist(tracklistList, this)

        tracklistRV.adapter = imageAdapterTracklist

        tracklistList.add(TracklistAttribute("Die For You", "Joji", R.drawable.cover_joji_smithereens))
        tracklistList.add(TracklistAttribute("Dissolve", "Joji", R.drawable.cover_joji_smithereens))
        tracklistList.add(TracklistAttribute("Before The Day Is Over", "Joji", R.drawable.cover_joji_smithereens))
        tracklistList.add(TracklistAttribute("YUKON (INTERLUDE)", "Joji", R.drawable.cover_joji_smithereens))
        tracklistList.add(TracklistAttribute("Nama Track", "Nama Artist", R.drawable.cover_white))
        tracklistList.add(TracklistAttribute("Nama Track", "Nama Artist", R.drawable.cover_white))
        tracklistList.add(TracklistAttribute("Nama Track", "Nama Artist", R.drawable.cover_white))
        tracklistList.add(TracklistAttribute("Nama Track", "Nama Artist", R.drawable.cover_white))
        tracklistList.add(TracklistAttribute("Nama Track", "Nama Artist", R.drawable.cover_white))
        tracklistList.add(TracklistAttribute("Nama Track", "Nama Artist", R.drawable.cover_white))
        tracklistList.add(TracklistAttribute("Nama Track", "Nama Artist", R.drawable.cover_white))
        tracklistList.add(TracklistAttribute("Nama Track", "Nama Artist", R.drawable.cover_white))

        imageAdapterTracklist.notifyDataSetChanged()


        //Fungsi Search
        btnsearch_tracklist.setOnQueryTextListener(object : SearchView.OnQueryTextListener,
            android.widget.SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(p0: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(msg: String): Boolean {

                filter(msg)
                return false
            }
        })
    }

    //filter digunakan untuk Fungsi Search
    private fun filter(text: String) {

        val filteredlist: ArrayList<TracklistAttribute> = ArrayList()


        for (item in tracklistList) {

            if (item.title.toLowerCase().contains(text.toLowerCase())) {

                filteredlist.add(item)
            }
        }
        if (filteredlist.isEmpty()) {

            Toast.makeText(this, "No Data Found..", Toast.LENGTH_SHORT).show()
        } else {

            imageAdapterTracklist.filterList(filteredlist)
        }
    }

    //Fungsi Button Back
    private fun back_tracklist() {
        tombolback_tracklist.setOnClickListener(

            View.OnClickListener {
                val i = Intent(
                    this,
                    Mylibrary::class.java
                )
                startActivity(i)
            }
        )
    }

    //Fungsi Listener RecyclerView
    override fun onItemClick(position: Int,) {
        Toast.makeText(this, "Playing " , Toast.LENGTH_LONG).show()
        imageAdapterTracklist.notifyItemChanged(position)
        val intent = Intent(this@TrackList, HomeMusic::class.java)
        startActivity(intent)
    }
}