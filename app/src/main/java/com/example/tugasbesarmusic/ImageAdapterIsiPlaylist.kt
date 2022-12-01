package com.example.tugasbesarmusic

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ImageAdapterIsiPlaylist (
    private val listIsiPlaylist: List<ModelIsiPlaylist>
) : RecyclerView.Adapter<ImageAdapterIsiPlaylist.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)= ViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.adapter_image_isiplaylist, parent, false)
    )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val isiPlaylist = listIsiPlaylist[position]
        holder.imageView.setImageResource( isiPlaylist.image )
        holder.textView_isiplaylist.text = isiPlaylist.judul
        holder.textView2_isiplaylist.text = isiPlaylist.pencipta
    }

    override fun getItemCount() = listIsiPlaylist.size

    class ViewHolder(view: View): RecyclerView.ViewHolder(view){
        val imageView = view.findViewById<ImageView>(R.id.imageView)
        val textView_isiplaylist = view.findViewById<TextView>(R.id.textView_isiplaylist)
        val textView2_isiplaylist = view.findViewById<TextView>(R.id.textView2_isiplaylist)
    }
}