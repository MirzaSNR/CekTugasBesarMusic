package com.example.tugasbesarmusic

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView

class TrackList : AppCompatActivity() {

    lateinit var courseRV: RecyclerView
    lateinit var imageAdapterTracklist: ImageAdapterTracklist
    lateinit var courseList: ArrayList<TracklistAttribute>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tracklist)

//        courseRV = findViewById(R.id.idRVCourses)

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
}