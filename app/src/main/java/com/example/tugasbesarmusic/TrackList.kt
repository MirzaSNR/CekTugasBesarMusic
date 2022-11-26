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

        imageAdapter()
        back_tracklist()
    }
    private fun back_tracklist(){
        tombolback_tracklist.setOnClickListener(
            View.OnClickListener {
                /*val i = Intent(
                   this,
                   halaman2::class.java)
                startActivity(i)
                BACK dicomment karena belum ada file
                xml yang menuju ke halaman tsb belum di push oleh rekan sekelompok */
            }
        )
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