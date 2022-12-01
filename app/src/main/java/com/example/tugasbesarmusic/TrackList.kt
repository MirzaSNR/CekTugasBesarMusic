package com.example.tugasbesarmusic

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_tracklist.*

class TrackList : AppCompatActivity() {

    lateinit var courseRV: RecyclerView
    lateinit var imageAdapterTracklist: ImageAdapterTracklist
    lateinit var courseList: ArrayList<TracklistAttribute>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tracklist)

        back_tracklist()
//

        courseRV = findViewById(R.id.idRVCourses)

        courseList = ArrayList()

        imageAdapterTracklist = ImageAdapterTracklist(courseList)

        courseRV.adapter = imageAdapterTracklist

        courseList.add(TracklistAttribute("Die For You", "Joji", R.drawable.cover_joji_smithereens))
        courseList.add(TracklistAttribute("Dissolve", "Joji", R.drawable.cover_joji_smithereens))
        courseList.add(TracklistAttribute("Before The Day Is Over", "Joji", R.drawable.cover_joji_smithereens))
        courseList.add(TracklistAttribute("YUKON (INTERLUDE)", "Joji", R.drawable.cover_joji_smithereens))
        courseList.add(TracklistAttribute("Nama Track", "Nama Artist", R.drawable.cover_white))
        courseList.add(TracklistAttribute("Nama Track", "Nama Artist", R.drawable.cover_white))
        courseList.add(TracklistAttribute("Nama Track", "Nama Artist", R.drawable.cover_white))
        courseList.add(TracklistAttribute("Nama Track", "Nama Artist", R.drawable.cover_white))
        courseList.add(TracklistAttribute("Nama Track", "Nama Artist", R.drawable.cover_white))
        courseList.add(TracklistAttribute("Nama Track", "Nama Artist", R.drawable.cover_white))
        courseList.add(TracklistAttribute("Nama Track", "Nama Artist", R.drawable.cover_white))
        courseList.add(TracklistAttribute("Nama Track", "Nama Artist", R.drawable.cover_white))

        imageAdapterTracklist.notifyDataSetChanged()
    }

    private fun back_tracklist(){
        tombolback_tracklist.setOnClickListener(

            View.OnClickListener {
                val i = Intent(
                    this,
                    Mylibrary::class.java)
                startActivity(i)
            }
        )
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // below line is to get our inflater
        val inflater = menuInflater

        // inside inflater we are inflating our menu file.
        inflater.inflate(R.menu.search_menu_tracklist, menu)

        // below line is to get our menu item.
        val searchItem: MenuItem = menu.findItem(R.id.actionSearch)

        // getting search view of our item.
        val searchView: SearchView = searchItem.getActionView() as SearchView

        // below line is to call set on query text listener method.
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener,
            android.widget.SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(p0: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(msg: String): Boolean {
                // inside on query text change method we are
                // calling a method to filter our recycler view.
                filter(msg)
                return false
            }
        })
        return true
    }

    private fun filter(text: String) {
        // creating a new array list to filter our data.
        val filteredlist: ArrayList<TracklistAttribute> = ArrayList()

        // running a for loop to compare elements.
        for (item in courseList) {
            // checking if the entered string matched with any item of our recycler view.
            if (item.title.toLowerCase().contains(text.toLowerCase())) {
                // if the item is matched we are
                // adding it to our filtered list.
                filteredlist.add(item)
            }
        }
        if (filteredlist.isEmpty()) {
            // if no item is added in filtered list we are
            // displaying a toast message as no data found.
            Toast.makeText(this, "No Data Found..", Toast.LENGTH_SHORT).show()
        } else {
            // at last we are passing that filtered
            // list to our adapter class.
            imageAdapterTracklist.filterList(filteredlist)
        }
    }
}