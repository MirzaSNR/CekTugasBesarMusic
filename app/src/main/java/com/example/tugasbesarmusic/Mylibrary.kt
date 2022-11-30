package com.example.tugasbesarmusic

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.RelativeLayout

class Mylibrary : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.mylibrary_layout)

        val clickback = findViewById<ImageView>(R.id.back_icon)
        clickback.setOnClickListener(){
            val intent = Intent(this@Mylibrary, HomeMusic::class.java)
            startActivity(intent)
        }

        val albumlist = findViewById<RelativeLayout>(R.id.albumlist)
        albumlist.setOnClickListener(){
            val intent = Intent(this@Mylibrary, MusicAlbum::class.java)
            startActivity(intent)
        }

        val tracklist = findViewById<RelativeLayout>(R.id.tracklist)
        tracklist.setOnClickListener(){
            val intent = Intent(this@Mylibrary, TrackList::class.java)
            startActivity(intent)
        }

        val folderList = findViewById<RelativeLayout>(R.id.folderlist)
        folderList.setOnClickListener(){
            val intent = Intent(this@Mylibrary, FolderList::class.java)
            startActivity(intent)
        }

        val playlist = findViewById<RelativeLayout>(R.id.playlist)
        playlist.setOnClickListener(){
            val intent = Intent(this@Mylibrary, IsiPlaylist::class.java)
            startActivity(intent)
        }

    }
}