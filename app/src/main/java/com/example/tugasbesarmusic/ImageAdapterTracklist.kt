package com.example.tugasbesarmusic

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class ImageAdapterTracklist(
    private var tracklistList: ArrayList<TracklistAttribute>,
    private val listener : OnItemClickListener
) : RecyclerView.Adapter<ImageAdapterTracklist.TrackViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ImageAdapterTracklist.TrackViewHolder {

        val itemView = LayoutInflater.from(parent.context).inflate(
            R.layout.adapter_image_tracklist,
            parent, false
        )

        return TrackViewHolder(itemView)
    }

    fun filterList(filterlist: ArrayList<TracklistAttribute>) {

        tracklistList = filterlist

        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: ImageAdapterTracklist.TrackViewHolder, position: Int) {
        // on below line we are setting data to our text view and our image view.

        holder.titleName.text = tracklistList.get(position).title
        holder.artistName.text = tracklistList.get(position).artist
        holder.imageTrack.setImageResource(tracklistList.get(position).image)
    }

    inner class TrackViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),
    View.OnClickListener{

        val titleName: TextView = itemView.findViewById(R.id.TextView_track)
        val artistName: TextView = itemView.findViewById(R.id.TextView_track2)
        val imageTrack: ImageView = itemView.findViewById(R.id.imageView_track)

        init{
            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            val position = adapterPosition
            if (position != RecyclerView.NO_POSITION){
                listener.onItemClick(position)
            }
        }
    }

    interface OnItemClickListener{
        fun onItemClick(position: Int)
    }

    override fun getItemCount(): Int {
        return  tracklistList.size
    }
}
