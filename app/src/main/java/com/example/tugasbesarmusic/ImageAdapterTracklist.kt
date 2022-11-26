package com.example.tugasbesarmusic

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ImageAdapterTracklist (
    private val listImage: List<Int>
) : RecyclerView.Adapter<ImageAdapterTracklist.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)= ViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.adapter_image_tracklist, parent, false)
    )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.image.setImageResource( listImage[position] )
        holder.text.setText("Nama Track" + position)
        holder.text2.setText("Nama Artist" + position)
    }

    override fun getItemCount() = listImage.size

    class ViewHolder(view: View): RecyclerView.ViewHolder(view){
        val image = view.findViewById<ImageView>(R.id.imageView)
        val text = view.findViewById<TextView>(R.id.textView)
        val text2 = view.findViewById<TextView>(R.id.textView2)
    }
}
