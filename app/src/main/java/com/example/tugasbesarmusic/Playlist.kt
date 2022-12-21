package com.example.tugasbesarmusic
//cek
class Playlist {
    lateinit var name: String
/*    lateinit var playlist: ArrayList<MusicTrack>*/
    lateinit var createdBy: String
    lateinit var createdOn: String
}
class MusicPlaylist {
    var ref: ArrayList<Playlist> = ArrayList()
}