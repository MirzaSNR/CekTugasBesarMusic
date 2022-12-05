package com.example.tugasbesarmusic

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class ImageAdapterIsiPlaylist(

    private var isiplaylist: ArrayList<IsiPlaylistAttribute>,
) : RecyclerView.Adapter<ImageAdapterIsiPlaylist.TrackViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ImageAdapterIsiPlaylist.TrackViewHolder {

        val itemView = LayoutInflater.from(parent.context).inflate(
            R.layout.adapter_image_isiplaylist,
            parent, false
        )

        return TrackViewHolder(itemView)
    }

    fun filterList(filterlist: ArrayList<IsiPlaylistAttribute>) {

        isiplaylist = filterlist

        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: ImageAdapterIsiPlaylist.TrackViewHolder, position: Int) {
        // on below line we are setting data to our text view and our image view.
        holder.titleName.text = isiplaylist.get(position).title
        holder.artistName.text = isiplaylist.get(position).artist
        holder.imageTrack.setImageResource(isiplaylist.get(position).image)
    }

    class TrackViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val titleName: TextView = itemView.findViewById(R.id.textView_isiplaylist)
        val artistName: TextView = itemView.findViewById(R.id.textView2_isiplaylist)
        val imageTrack: ImageView = itemView.findViewById(R.id.imageView)
    }

    override fun getItemCount(): Int {
        return  isiplaylist.size
    }
}
