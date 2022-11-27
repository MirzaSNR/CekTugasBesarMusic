package com.example.tugasbesarmusic

import android.content.Intent
import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_tracklist.*

class TrackList : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tracklist)

        modelAdapterTrackList()
//        back_tracklist()
    }
//    private fun back_tracklist(){
//        tombolback_tracklist.setOnClickListener(
//            View.OnClickListener {
//                val i = Intent(
//                   this,
//                   halaman2::class.java)
//                startActivity(i)
//
//                modelAdapterTrackList()
//            }
//        )
//    }

    private fun modelAdapterTrackList(){
        val tracklist = listOf<ModelTrackList>(
            ModelTrackList(1, "Die For You", "Joji", R.drawable.cover_joji_smithereens),
            ModelTrackList(2, "Dissolve", "Joji", R.drawable.cover_joji_smithereens),
            ModelTrackList(3, "Before The Day Is Over", "Joji", R.drawable.cover_joji_smithereens),
            ModelTrackList(4, "YUKON (INTERLUDE)", "Joji", R.drawable.cover_joji_smithereens),
            ModelTrackList(5, "Nama Track", "Nama Artist", R.drawable.cover_white),
            ModelTrackList(6, "Nama Track", "Nama Artist", R.drawable.cover_white),
            ModelTrackList(7, "Nama Track", "Nama Artist", R.drawable.cover_white),
            ModelTrackList(8, "Nama Track", "Nama Artist", R.drawable.cover_white),
            ModelTrackList(9, "Nama Track", "Nama Artist", R.drawable.cover_white),
            ModelTrackList(10, "Nama Track", "Nama Artist", R.drawable.cover_white),
            ModelTrackList(11, "Nama Track", "Nama Artist", R.drawable.cover_white),
            ModelTrackList(12, "Nama Track", "Nama Artist", R.drawable.cover_white),
        )

        val imageAdapterTracklist = ImageAdapterTracklist( tracklist )
        findViewById<RecyclerView>(R.id.recyclerView).adapter = imageAdapterTracklist
    }
}