package com.example.tugasbesarmusic

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_home_music.*

class HomeMusic : AppCompatActivity() {
    var repeatsatu :Boolean = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_music)

        val ibtn1:ImageButton=findViewById(R.id.ibtn1)
        ibtn1.setOnClickListener {
            startActivity(Intent(this,TrackList::class.java)   )
        }
        ibtnsetting.setOnClickListener {
            val intent:Intent = Intent(this, SettingAplikasi::class.java)
            startActivity(intent)
        }
        btnrepeat_HomeMusic.setOnClickListener {
            if (!repeatsatu){
                repeatsatu = true
                btnrepeat_HomeMusic.setBackgroundResource(R.drawable.repeat)
                Toast.makeText(this,"Repeat Satu", Toast.LENGTH_SHORT).show()
            }else{
                repeatsatu = false
                btnrepeat_HomeMusic.setBackgroundResource(R.drawable.repeat)
                Toast.makeText(this,"Repeat Semua", Toast.LENGTH_SHORT).show()
            }
        }

    }
}