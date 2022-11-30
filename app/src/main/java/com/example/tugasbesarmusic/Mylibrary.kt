package com.example.tugasbesarmusic

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class Mylibrary : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.mylibrary_layout)

        val clickback = findViewById<ImageView>(R.id.back_icon)
        clickback.setOnClickListener(){
            val intent = Intent(this, IsiPlaylist::class.java)
            startActivity(intent)
        }
    }
}