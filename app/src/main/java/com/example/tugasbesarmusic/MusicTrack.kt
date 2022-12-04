package com.tubes.musicappproject

data class MusicTrack(
    val id: Long = 0,
    val title: String,
    val album: String,
    val artist: String,
    val path: String,
    val duration: Long = 0,
    val artUri: String = ""
)

class Playlist {
    lateinit var name: String
    lateinit var playlist: ArrayList<MusicTrack>
    lateinit var createdBy: String
    lateinit var createdOn: String
}

class MusicPlaylist {
    var ref: ArrayList<Playlist> = ArrayList()
}
