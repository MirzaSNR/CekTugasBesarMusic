package com.example.tugasbesarmusic

import android.os.Bundle
import android.widget.ImageView
import android.widget.SearchView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.tubes.musicappproject.MusicTrack
//cek
class FolderList : AppCompatActivity() {
    private  lateinit var gridPlaylistAdapter: GridAlbumAdapter
    companion object {
        lateinit var list:ArrayList<MusicTrack>
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_folderlist)
        val button : ImageView = findViewById(R.id.button_back_album)
        button.setOnClickListener(){
            onBackPressed()
        }
        val searching : SearchView = findViewById(R.id.searching)
        searching.clearFocus()
        searching.setOnQueryTextListener(object : SearchView.OnQueryTextListener,
            androidx.appcompat.widget.SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                filter(newText)
                return true
            }
        })
    }
    private fun filter(newText: String?) {
        val listM: ArrayList<MusicTrack> = ArrayList()
        for (item in list) {
            if (item.title.lowercase().contains(newText!!.lowercase())) {
                listM.add(item)
            }
        }
        if (listM.isEmpty()) {
            Toast.makeText(this, "Song not found", Toast.LENGTH_SHORT).show()
        } else {
            gridPlaylistAdapter.setfilter(listM)
        }
    }

}