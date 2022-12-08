package com.example.tugasbesarmusic

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.SeekBar
import android.widget.Toast
import androidx.core.util.TimeUtils.formatDuration
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
      //     try {
        //       val bundle: Bundle? = intent.extras

          //     if (bundle != null) {
            //       initializeLayout(bundle)
                }
        // seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
          //   override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
            //     if (p2) {
              //       mediaPlayer!!.seekTo(p1)
        //             start.text = formatDuration(mediaPlayer!!.currentPosition.toLong())
               //  }
             // }

           //  override fun onStartTrackingTouch(p0: SeekBar?) {

             // }

            // override fun onStopTrackingTouch(p0: SeekBar?) {

            // }

   // }
     //       catch (e: Exception) {
           //     Toast.makeText(this, "Error" + e.message, Toast.LENGTH_SHORT).show()
            //}

       //     next.setOnClickListener { prevNextSong(increment = true) }
         //   fab_prev.setOnClickListener { prevNextSong(increment = false) }
          //  fab_play.setOnClickListener {
            //    if (isPlaying)
              //      pause()
              //  else
                //    play()
           // }
   // }
// }