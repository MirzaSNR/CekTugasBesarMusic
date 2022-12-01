package com.example.tugasbesarmusic

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class ImageAdapterTracklist(

    private var tracklistList: ArrayList<TracklistAttribute>,
) : RecyclerView.Adapter<ImageAdapterTracklist.tracklistHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ImageAdapterTracklist.tracklistHolder {

        val itemView = LayoutInflater.from(parent.context).inflate(
            R.layout.adapter_image_tracklist,
            parent, false
        )

        return tracklistHolder(itemView)
    }

    fun filterList(filterlist: ArrayList<TracklistAttribute>) {

        tracklistList = filterlist

        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: ImageAdapterTracklist.tracklistHolder, position: Int) {
        // on below line we are setting data to our text view and our image view.
        holder.titleName.text = tracklistList.get(position).title
        holder.artistName.text = tracklistList.get(position).artist
        holder.imageTrack.setImageResource(tracklistList.get(position).image)
    }

    class tracklistHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val titleName: TextView = itemView.findViewById(R.id.TextView_track)
        val artistName: TextView = itemView.findViewById(R.id.TextView_track2)
        val imageTrack: ImageView = itemView.findViewById(R.id.imageView_track)
    }

    override fun getItemCount(): Int {
        return  tracklistList.size
    }
}
