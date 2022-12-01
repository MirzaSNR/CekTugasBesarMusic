package com.example.tugasbesarmusic

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import kotlinx.android.synthetic.main.activity_home_music.*

class HomeMusic : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_music)

        val ibtn1:ImageButton=findViewById(R.id.ibtn1)
        ibtn1.setOnClickListener {
            startActivity(Intent(this,TrackList::class.java)   )
        }
    }
}