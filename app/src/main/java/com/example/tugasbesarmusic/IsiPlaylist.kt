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
        val isiPlaylist = listOf<ModelIsiPlaylist>(
            ModelIsiPlaylist(1, "Cinta Butuh Waktu", "Vierratele", R.drawable.viera),
            ModelIsiPlaylist(2, "Seandainya", "Vierratele", R.drawable.vieera),
            ModelIsiPlaylist(3, "Perih", "Vierratele", R.drawable.vieraaa),
            ModelIsiPlaylist(4, "Dengarkan Curhatku", "Vierratele", R.drawable.vierra),
            ModelIsiPlaylist(5, "Rasa Ini", "Vierratele", R.drawable.vierrraa),
            ModelIsiPlaylist(6, "Tinggalkanku", "Vierratele", R.drawable.cover_white),
            ModelIsiPlaylist(7, "Nama Track", "Nama Artist", R.drawable.cover_white),
            ModelIsiPlaylist(8, "Nama Track", "Nama Artist", R.drawable.cover_white),
            ModelIsiPlaylist(9, "Nama Track", "Nama Artist", R.drawable.cover_white),
            ModelIsiPlaylist(10, "Nama Track", "Nama Artist", R.drawable.cover_white),
            ModelIsiPlaylist(11, "Nama Track", "Nama Artist", R.drawable.cover_white),
            ModelIsiPlaylist(12, "Nama Track", "Nama Artist", R.drawable.cover_white),
        )

        val imageAdapterIsiPlaylist = ImageAdapterIsiPlaylist( isiPlaylist )
        findViewById<RecyclerView>(R.id.recyclerView).adapter = imageAdapterIsiPlaylist
    }

    }
