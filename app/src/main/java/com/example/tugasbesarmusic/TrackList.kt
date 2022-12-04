package com.example.tugasbesarmusic

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_tracklist.*

class TrackList : AppCompatActivity() {

    lateinit var courseRV: RecyclerView
    lateinit var imageAdapterTracklist: ImageAdapterTracklist
    lateinit var courseList: ArrayList<TracklistAttribute>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tracklist)

        back_tracklist()
//

        courseRV = findViewById(R.id.idRVCourses)

        courseList = ArrayList()

        imageAdapterTracklist = ImageAdapterTracklist(courseList)

        courseRV.adapter = imageAdapterTracklist

        courseList.add(TracklistAttribute("Die For You", "Joji", R.drawable.cover_joji_smithereens))
        courseList.add(TracklistAttribute("Dissolve", "Joji", R.drawable.cover_joji_smithereens))
        courseList.add(TracklistAttribute("Before The Day Is Over", "Joji", R.drawable.cover_joji_smithereens))
        courseList.add(TracklistAttribute("YUKON (INTERLUDE)", "Joji", R.drawable.cover_joji_smithereens))
        courseList.add(TracklistAttribute("Nama Track", "Nama Artist", R.drawable.cover_white))
        courseList.add(TracklistAttribute("Nama Track", "Nama Artist", R.drawable.cover_white))
        courseList.add(TracklistAttribute("Nama Track", "Nama Artist", R.drawable.cover_white))
        courseList.add(TracklistAttribute("Nama Track", "Nama Artist", R.drawable.cover_white))
        courseList.add(TracklistAttribute("Nama Track", "Nama Artist", R.drawable.cover_white))
        courseList.add(TracklistAttribute("Nama Track", "Nama Artist", R.drawable.cover_white))
        courseList.add(TracklistAttribute("Nama Track", "Nama Artist", R.drawable.cover_white))
        courseList.add(TracklistAttribute("Nama Track", "Nama Artist", R.drawable.cover_white))

        imageAdapterTracklist.notifyDataSetChanged()
    }

    //Fungsi Button Back
    private fun back_tracklist(){
        tombolback_tracklist.setOnClickListener(

            View.OnClickListener {
                val i = Intent(
                    this,
                    Mylibrary::class.java)
                startActivity(i)
            }
        )
    }

    //Fungsi Search
    override fun onCreateOptionsMenu(menu: Menu): Boolean {

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
        return true
    }

    //filter digunakan untuk Fungsi Search
    private fun filter(text: String) {

        val filteredlist: ArrayList<TracklistAttribute> = ArrayList()


        for (item in courseList) {

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
}