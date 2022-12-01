package com.example.tugasbesarmusic

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class ImageAdapterTracklist(

    private var courseList: ArrayList<TracklistAttribute>,
) : RecyclerView.Adapter<ImageAdapterTracklist.CourseViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ImageAdapterTracklist.CourseViewHolder {

        val itemView = LayoutInflater.from(parent.context).inflate(
            R.layout.adapter_image_tracklist,
            parent, false
        )

        return CourseViewHolder(itemView)
    }

    fun filterList(filterlist: ArrayList<TracklistAttribute>) {

        courseList = filterlist

        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: ImageAdapterTracklist.CourseViewHolder, position: Int) {
        // on below line we are setting data to our text view and our image view.
        holder.titleName.text = courseList.get(position).title
        holder.artistName.text = courseList.get(position).artist
        holder.imageTrack.setImageResource(courseList.get(position).image)
    }

    class CourseViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val titleName: TextView = itemView.findViewById(R.id.TextView_track)
        val artistName: TextView = itemView.findViewById(R.id.TextView_track2)
        val imageTrack: ImageView = itemView.findViewById(R.id.imageView_track)
    }

    override fun getItemCount(): Int {
        return  courseList.size
    }
}
