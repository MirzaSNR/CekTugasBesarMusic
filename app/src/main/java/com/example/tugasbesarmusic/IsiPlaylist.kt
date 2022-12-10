package com.example.cloneproject

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.RecyclerView
import com.example.tugasbesarmusic.AdapterIsiPlaylist
import com.example.tugasbesarmusic.musicAttribute
import kotlinx.android.synthetic.main.activity_isi_playlist.*

class IsiPlaylist :AppCompatActivity() {
    lateinit var isiplaylistRV: RecyclerView
    lateinit var imageAdapterisiPlaylist: AdapterIsiPlaylist
    lateinit var addIsiPlaylist: ArrayList<musicAttribute>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_isi_playlist)

        back_addtrack()

        isiplaylistRV = findViewById(R.id.idRVIsiplaylist)

        addIsiPlaylist = ArrayList()

        imageAdapterisiPlaylist = AdapterIsiPlaylist(addIsiPlaylist)

        isiplaylistRV.adapter = imageAdapterisiPlaylist

        addIsiPlaylist.add(musicAttribute("Die For You", "Joji", R.drawable.cover_joji_smithereens))
        addIsiPlaylist.add(musicAttribute("Dissolve", "Joji", R.drawable.cover_joji_smithereens))
        addIsiPlaylist.add(musicAttribute("Before The Day Is Over", "Joji", R.drawable.cover_joji_smithereens))
        addIsiPlaylist.add(musicAttribute("YUKON (INTERLUDE)", "Joji", R.drawable.cover_joji_smithereens))

        imageAdapterisiPlaylist.notifyDataSetChanged()

        //Fungsi Search
        btnsearch_isiplaylist.setOnQueryTextListener(object : SearchView.OnQueryTextListener,
            android.widget.SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(p0: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(msg: String): Boolean {

                filter(msg)
                return false
            }
        })
    }

    //filter digunakan untuk Fungsi Search
    private fun filter(text: String) {

        val filteredlist: ArrayList<musicAttribute> = ArrayList()


        for (item in addIsiPlaylist) {

            if (item.title.toLowerCase().contains(text.toLowerCase())) {

                filteredlist.add(item)
            }
        }
        if (filteredlist.isEmpty()) {

            Toast.makeText(this, "No Data Found..", Toast.LENGTH_SHORT).show()
        } else {

            imageAdapterisiPlaylist.filterList(filteredlist)
        }
    }

    //Fungsi Button Back
    private fun back_addtrack(){
        tombolback_isiplaylist.setOnClickListener(

            View.OnClickListener {
                val i = Intent(
                    this,
                    TrackList::class.java)
                startActivity(i)
            }
        )
    }
}
