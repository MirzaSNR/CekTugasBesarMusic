package com.example.tugasbesarmusic

import android.content.ContentUris
import android.content.Context
import android.content.Intent
import android.media.MediaPlayer
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.provider.MediaStore
import android.text.TextUtils
import android.util.Log
import android.widget.SeekBar
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.tugasbesarmusic.GridAlbumDetailAdapter.Companion.tracklist
import com.example.tugasbesarmusic.HomeMusic.Companion.repeat_one

import com.tubes.musicappproject.DataMusic
import com.tubes.musicappproject.MusicTrack

import kotlinx.android.synthetic.main.activity_home_music.*

import java.util.concurrent.TimeUnit

class HomeMusic : AppCompatActivity() {

    companion object {
        lateinit var musicListPlayer: ArrayList<MusicTrack>
        var songPosition: Int = 0
        var mediaPlayer: MediaPlayer? = null
        var isPlaying: Boolean = false
        var repeat_one: Boolean = false
        var duration: Double = 0.0
        var current_time: Double = 0.0
        private lateinit var runnable: Runnable
    }

    override fun onBackPressed() {
        super.onBackPressed()
        pause()
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_music)

        //bikin marquee di player-activity
        judul.ellipsize = TextUtils.TruncateAt.MARQUEE
        judul.ellipsize = TextUtils.TruncateAt.MARQUEE
        judul.setHorizontallyScrolling(true)
        judul.marqueeRepeatLimit = -1
        judul.isFocusable = true
        judul.isFocusableInTouchMode = true
        //store shared preference setting path
        val sharedPreference =  getSharedPreferences("PREFERENCE_NAME",Context.MODE_PRIVATE)
        val cek = sharedPreference.getString("username","defaultName")
        sharedPreference.getLong("l",1L)
        Log.i("test_1", "Ini pathnya $cek")

        btn_back.setOnClickListener {
            val intent = Intent(this@HomeMusic, Mylibrary::class.java)
            startActivity(intent)
        }
        btnsetting.setOnClickListener {
            val intent:Intent = Intent(this@HomeMusic, SettingAplikasi::class.java)
            startActivity(intent)
        }

        try {
            val bundle: Bundle? = intent.extras

            if (bundle != null) {
                initializeLayout(bundle)
            }

            seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
                override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                    if (p2) {
                        mediaPlayer!!.seekTo(p1)
                        start.text = formatDuration(mediaPlayer!!.currentPosition.toLong())
                    }
                }

                override fun onStartTrackingTouch(p0: SeekBar?) {

                }

                override fun onStopTrackingTouch(p0: SeekBar?) {

                }

            })


        } catch (e: Exception) {
            Toast.makeText(this, "Error" + e.message, Toast.LENGTH_SHORT).show()
        }

        fab_next.setOnClickListener { prevNextSong(increment = true) }
        fab_prev.setOnClickListener { prevNextSong(increment = false) }
        fab_play.setOnClickListener {
            if (isPlaying)
                pause()
            else
                play()
        }

        fab_repeat.setOnClickListener {
            if (!repeat_one) {
                repeat_one = true
                fab_repeat.setBackgroundResource(R.drawable.repeatone)
                Toast.makeText(this, "Repeat One", Toast.LENGTH_SHORT).show()
            } else {
                repeat_one = false
                fab_repeat.setBackgroundResource(R.drawable.repeat)
                Toast.makeText(this, "Repeat All", Toast.LENGTH_SHORT).show()
            }
        }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun initializeLayout(bundle: Bundle){
        when (bundle.getString("music", "")){
            "track" -> {
                musicListPlayer = GridAlbumDetailAdapter.tracklist
                songPosition = bundle.getInt("position", 0)
                initialize()
                createMedia()
            }

            "album" -> {
                val item = bundle.getString("item", "")
                musicListPlayer = getDetailAlbum(this, item)
                songPosition = bundle.getInt("position", 0)
                initialize()
                createMedia()
            }
        }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun getDetailAlbum(context: Context, item: String): ArrayList<MusicTrack>{
        val arrayAlbum = DataMusic.getAllAudioTrack(context)
        val newArray: ArrayList<MusicTrack> = ArrayList()

        arrayAlbum.forEach {
            if (it.album.equals(item)){
                newArray.add(it)
            }
        }

        return newArray

    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun seekbar() {

    }

    fun formatDuration(duration: Long): String {
        val minutes = TimeUnit.MINUTES.convert(duration, TimeUnit.MILLISECONDS)
        val seconds = (TimeUnit.SECONDS.convert(duration, TimeUnit.MILLISECONDS) -
                minutes * TimeUnit.SECONDS.convert(1, TimeUnit.MINUTES))
        return String.format("%02d:%02d", minutes, seconds)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun initialize() {

        judul.text = musicListPlayer[songPosition].title
        album.text = musicListPlayer[songPosition].album
        artist.text = musicListPlayer[songPosition].artist

        Glide.with(this)
            .load(musicListPlayer[songPosition].artUri)
            .apply(RequestOptions().placeholder(R.drawable.cover_white).fitCenter())
            .into(img_player)

    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun createMedia() {
        val contentUri: Uri = ContentUris.withAppendedId(
            MediaStore.Audio.Media.EXTERNAL_CONTENT_URI,
            musicListPlayer[songPosition].id
        )
        mediaPlayer = MediaPlayer()

        start.text = formatDuration(mediaPlayer!!.currentPosition.toLong())
        mediaPlayer!!.reset()
        mediaPlayer?.setDataSource(applicationContext, contentUri)
        mediaPlayer!!.prepare()
        mediaPlayer?.start()
        isPlaying = true
        fab_play.setImageResource(R.drawable.pause)
        seekBar.progress = 0
        seekBar.max = mediaPlayer!!.duration
        end.text = formatDuration(mediaPlayer!!.duration.toLong())

        runnable = Runnable {
            start.text = formatDuration(mediaPlayer!!.currentPosition.toLong())
            seekBar.progress = mediaPlayer!!.currentPosition
            Handler(Looper.getMainLooper()).postDelayed(runnable, 200)

        }
        Handler(Looper.getMainLooper()).postDelayed(runnable, 0)
        mediaPlayer!!.setOnCompletionListener {

            if (repeat_one) {
                initialize()
                createMedia()
            } else {
                next()
            }
        }
    }

    private fun repeat_one() {
        val contentUri: Uri = ContentUris.withAppendedId(
            MediaStore.Audio.Media.EXTERNAL_CONTENT_URI,
            musicListPlayer[songPosition].id
        )
        mediaPlayer = MediaPlayer()
        mediaPlayer!!.reset()
        mediaPlayer?.setDataSource(applicationContext, contentUri)
        mediaPlayer!!.prepare()
        mediaPlayer!!.isLooping
        mediaPlayer?.start()
        isPlaying = true
        fab_play.setImageResource(R.drawable.pause)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun next() {
        mediaPlayer!!.pause()
        ++songPosition
        initialize()
        createMedia()
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun prev() {
        mediaPlayer!!.pause()
        --songPosition
        initialize()
        createMedia()
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun prevNextSong(increment: Boolean) {
        if (increment) {
            if (repeat_one) {
                mediaPlayer!!.pause()
                initialize()
                repeat_one()
            } else {
                next()
            }


        } else {
            if (repeat_one) {
                mediaPlayer!!.pause()
                initialize()
                repeat_one()
            } else {
                prev()
            }

        }
    }

    private fun play() {
        fab_play.setImageResource(R.drawable.pause)
        isPlaying = true
        mediaPlayer!!.start()
    }

    private fun pause() {
        fab_play.setImageResource(R.drawable.play)
        isPlaying = false
        mediaPlayer!!.pause()
    }

}