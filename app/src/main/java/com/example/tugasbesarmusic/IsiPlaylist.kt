package com.example.tugasbesarmusic

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_isi_playlist.*
//cek
class IsiPlaylist : AppCompatActivity() {

    lateinit var isiplaylistRV: RecyclerView
    lateinit var imageAdapterIsiPlaylist: AdapterIsiPlaylist
    lateinit var isiplaylistList: ArrayList<IsiPlaylistAttribute>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_isi_playlist)

        back_isiplaylist()
//

        isiplaylistRV = findViewById(R.id.idRVIsiplaylist)

        isiplaylistList = ArrayList()

        imageAdapterIsiPlaylist = AdapterIsiPlaylist(isiplaylistList)

        isiplaylistRV.adapter = imageAdapterIsiPlaylist

        isiplaylistList.add(IsiPlaylistAttribute("Die For You", "Joji", R.drawable.cover_joji_smithereens))
        isiplaylistList.add(IsiPlaylistAttribute("Dissolve", "Joji", R.drawable.cover_joji_smithereens))
        isiplaylistList.add(IsiPlaylistAttribute("Before The Day Is Over", "Joji", R.drawable.cover_joji_smithereens))
        isiplaylistList.add(IsiPlaylistAttribute("YUKON (INTERLUDE)", "Joji", R.drawable.cover_joji_smithereens))
        isiplaylistList.add(IsiPlaylistAttribute("Nama Track", "Nama Artist", R.drawable.cover_white))
        isiplaylistList.add(IsiPlaylistAttribute("Nama Track", "Nama Artist", R.drawable.cover_white))
        isiplaylistList.add(IsiPlaylistAttribute("Nama Track", "Nama Artist", R.drawable.cover_white))
        isiplaylistList.add(IsiPlaylistAttribute("Nama Track", "Nama Artist", R.drawable.cover_white))
        isiplaylistList.add(IsiPlaylistAttribute("Nama Track", "Nama Artist", R.drawable.cover_white))
        isiplaylistList.add(IsiPlaylistAttribute("Nama Track", "Nama Artist", R.drawable.cover_white))
        isiplaylistList.add(IsiPlaylistAttribute("Nama Track", "Nama Artist", R.drawable.cover_white))
        isiplaylistList.add(IsiPlaylistAttribute("Nama Track", "Nama Artist", R.drawable.cover_white))

        imageAdapterIsiPlaylist.notifyDataSetChanged()

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

        val filteredlist: ArrayList<IsiPlaylistAttribute> = ArrayList()


        for (item in isiplaylistList) {

            if (item.title.toLowerCase().contains(text.toLowerCase())) {

                filteredlist.add(item)
            }
        }
        if (filteredlist.isEmpty()) {

            Toast.makeText(this, "No Data Found..", Toast.LENGTH_SHORT).show()
        } else {

            imageAdapterIsiPlaylist.filterList(filteredlist)
        }
    }

    //Fungsi Button Back
    private fun back_isiplaylist(){
        tombolback_isiplaylist.setOnClickListener(

            View.OnClickListener {
                val i = Intent(
                    this,
                    Mylibrary::class.java)
                startActivity(i)
            }
        )
    }}
