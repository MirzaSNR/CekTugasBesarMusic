package com.example.tugasbesarmusic
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.tubes.musicappproject.DataMusic
import com.tubes.musicappproject.MusicTrack

class AlbumActivity : AppCompatActivity() {
    private lateinit var rv_album: RecyclerView
    private lateinit var list: ArrayList<MusicTrack>
    private lateinit var gridAlbumAdapter: GridAlbumAdapter
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_album)
        rv_album = findViewById(R.id.rv_album)
        rv_album.setHasFixedSize(true)
        list = DataMusic.getAlbumList(this@AlbumActivity)
        showRecyclerGrid()
        val clickback = findViewById<ImageView>(R.id.button_back_album)
        clickback.setOnClickListener(){
            val i = Intent(this, MainActivity::class.java)
            startActivity(i)
        }
    }

    private fun showRecyclerGrid() {
        rv_album.layoutManager = GridLayoutManager(this@AlbumActivity, 2)
        gridAlbumAdapter = GridAlbumAdapter(list)
        rv_album.adapter = gridAlbumAdapter
    }
}
