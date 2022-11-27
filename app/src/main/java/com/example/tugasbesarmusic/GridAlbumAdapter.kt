//package com.example.tugasbesarmusic
//import android.content.Intent
//import androidx.recyclerview.widget.RecyclerView
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import android.widget.ImageView
//import android.widget.TextView
//import androidx.core.content.ContextCompat.startActivity
//import com.bumptech.glide.Glide
//import com.bumptech.glide.request.RequestOptions
//import com.example.tugasbesarmusic.R
//import java.util.*
//class GridAlbumAdapter internal constructor(private val gridAlbumList:
//                                            ArrayList<MusicTrack>) :
//    RecyclerView.Adapter<GridAlbumAdapter.GridViewHolder>() {
//    private lateinit var onItemClickCallback: OnItemClickCallback
//    internal fun setOnItemClickCallback(onItemClickCallback:
//                                        OnItemClickCallback) {
//        this.onItemClickCallback = onItemClickCallback
//    }
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
//            GridViewHolder {
//        val view: View =
//            LayoutInflater.from(parent.context).inflate(R.layout.grid_album, parent,
//                false)
//        return GridViewHolder(view)
//    }
//    override fun onBindViewHolder(holder: GridViewHolder, position: Int) {
//        val grid = gridAlbumList[position]
//        Glide.with(holder.itemView.context)
//            .load(gridAlbumList[position].artUri)
//            .apply(RequestOptions().placeholder(R.drawable.coverwhite).fitCenter())
//            .into(holder.imgPhoto)
//        holder.itemView.setOnClickListener {
//            val intent = Intent(holder.itemView.context, DetailAlbumActivity::class.java)
//            intent.putExtra("item", grid.album)
//            holder.itemView.context.startActivity(intent)
//        }
//        holder.title.text = grid.album
//    }
//    override fun getItemCount(): Int {
//        return gridAlbumList.size
//    }
//    inner class GridViewHolder(itemView: View) :
//        RecyclerView.ViewHolder(itemView) {
//        var imgPhoto: ImageView =
//            itemView.findViewById(R.id.image_Album)
//        var title: TextView = itemView.findViewById(R.id.name_Album)
//    }

//    interface OnItemClickCallback {
//        fun onItemClicked(data: MusicTrack)
//    }
//}