package com.example.tugasbesarmusic

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AdapterIsiPlaylist (
    private var isiplaylist: ArrayList<IsiPlaylistAttribute>,
) : RecyclerView.Adapter<AdapterIsiPlaylist.TrackViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): AdapterIsiPlaylist.TrackViewHolder {

        val itemViewadapter_isiplaylist = LayoutInflater.from(parent.context).inflate(
            R.layout.adapter_image_isiplaylist,
            parent, false
        )

        return TrackViewHolder(itemViewadapter_isiplaylist)
    }

    fun filterList(filterlist: ArrayList<IsiPlaylistAttribute>) {

        isiplaylist = filterlist

        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: AdapterIsiPlaylist.TrackViewHolder, position: Int) {
        // on below line we are setting data to our text view and our image view.
        holder.titleName.text = isiplaylist.get(position).title
        holder.artistName.text = isiplaylist.get(position).artist
        holder.imageTrack.setImageResource(isiplaylist.get(position).image)
    }

    class TrackViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val titleName: TextView = itemView.findViewById(R.id.TextView_isiplaylist)
        val artistName: TextView = itemView.findViewById(R.id.TextView_isiplaylist2)
        val imageTrack: ImageView = itemView.findViewById(R.id.imageView_isiplaylist)
    }

    override fun getItemCount(): Int {
        return  isiplaylist.size
    }
}