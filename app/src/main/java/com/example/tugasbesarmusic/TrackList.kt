package com.example.tugasbesarmusic

import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class TrackList : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tracklist)

        imageAdapter()

    }

    private fun imageAdapter(){
        val images = listOf<Int>(
            R.drawable.cover_white,
            R.drawable.cover_white,
            R.drawable.cover_white,
            R.drawable.cover_white,
            R.drawable.cover_white,
            R.drawable.cover_white,
            R.drawable.cover_white,
            R.drawable.cover_white,
            R.drawable.cover_white,
            R.drawable.cover_white,
            R.drawable.cover_white,
            R.drawable.cover_white,
        )

        val imageAdapterTracklist = ImageAdapterTracklist( images )
        findViewById<RecyclerView>(R.id.recyclerView).adapter = imageAdapterTracklist
    }
}