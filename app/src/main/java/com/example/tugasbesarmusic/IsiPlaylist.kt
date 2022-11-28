package com.example.tugasbesarmusic

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView

class IsiPlaylist: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_isi_playlist)

        modelAdapterIsiPlaylist()
    }
    private fun modelAdapterIsiPlaylist(){
        val isiPlaylist = listOf<ModelTrackList>(
            ModelTrackList(1, "Cinta Butuh Waktu", "Vierratele", R.drawable.viera),
            ModelTrackList(2, "Seandainya", "Vierratele", R.drawable.vieera),
            ModelTrackList(3, "Perih", "Vierratele", R.drawable.vieraaa),
            ModelTrackList(4, "Dengarkan Curhatku", "Vierratele", R.drawable.vierra),
            ModelTrackList(5, "Rasa Ini", "Vierratele", R.drawable.vierrraa),
            ModelTrackList(6, "Tinggalkanku", "Vierratele", R.drawable.cover_white),
            ModelTrackList(7, "Nama Track", "Nama Artist", R.drawable.cover_white),
            ModelTrackList(8, "Nama Track", "Nama Artist", R.drawable.cover_white),
            ModelTrackList(9, "Nama Track", "Nama Artist", R.drawable.cover_white),
            ModelTrackList(10, "Nama Track", "Nama Artist", R.drawable.cover_white),
            ModelTrackList(11, "Nama Track", "Nama Artist", R.drawable.cover_white),
            ModelTrackList(12, "Nama Track", "Nama Artist", R.drawable.cover_white),
        )

        val imageAdapterIsiPlaylist = ImageAdapterTracklist( isiPlaylist )
        findViewById<RecyclerView>(R.id.recyclerView).adapter = imageAdapterIsiPlaylist
    }

    }
