package com.example.tugasbesarmusic

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class IsiPlaylist: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_isi_playlist)

        modelAdapterIsiPlaylist()


    }

    private fun modelAdapterIsiPlaylist() {
        val tracklist = listOf<ModelTrackList>(
            ModelTrackList(1, "Cinta Butuh Waktu", "Vierratele", R.drawable.vierrraa),
            ModelTrackList(2, "Seandainya", "Vierratele", R.drawable.vierra),
            ModelTrackList(3, "Perih", "Vierratele", R.drawable.vieraaa),
            ModelTrackList(4, "Dengarkan Curhatku", "Vierratele", R.drawable.vieera),
            ModelTrackList(5, "Rasa Ini", "Vierratele", R.drawable.viera),
            ModelTrackList(6, "Tinggalkanku", "Vierratele", R.drawable.cover_white),
            ModelTrackList(7, "Nama Track", "Nama Artist", R.drawable.cover_white),
            ModelTrackList(8, "Nama Track", "Nama Artist", R.drawable.cover_white),
            ModelTrackList(9, "Nama Track", "Nama Artist", R.drawable.cover_white),
            ModelTrackList(10, "Nama Track", "Nama Artist", R.drawable.cover_white),
            ModelTrackList(11, "Nama Track", "Nama Artist", R.drawable.cover_white),
            ModelTrackList(12, "Nama Track", "Nama Artist", R.drawable.cover_white),
        )
    }
}