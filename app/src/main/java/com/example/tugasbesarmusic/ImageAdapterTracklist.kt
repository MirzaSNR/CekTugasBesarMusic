package com.example.tugasbesarmusic

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ImageAdapterTracklist (
    private val listTrackList: List<ModelTrackList>
) : RecyclerView.Adapter<ImageAdapterTracklist.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)= ViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.adapter_image_tracklist, parent, false)
    )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val tracklist = listTrackList[position]
        holder.imageView.setImageResource( tracklist.image )
        holder.textView.text = tracklist.name
        holder.textView2.text = tracklist.name2
    }

    override fun getItemCount() = listTrackList.size

    class ViewHolder(view: View): RecyclerView.ViewHolder(view){
        val imageView = view.findViewById<ImageView>(R.id.imageView)
        val textView = view.findViewById<TextView>(R.id.textView)
        val textView2 = view.findViewById<TextView>(R.id.textView2)
    }
}
