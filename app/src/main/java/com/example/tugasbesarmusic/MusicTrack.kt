package com.example.tugasbesarmusic

import android.provider.MediaStore

class MusicTrack {
    lateinit var name: String
    lateinit var playlist: ArrayList<MusicTrack>
    lateinit var createdBy: String
    lateinit var createdOn: String
}
class MusicPlaylist {
    var ref: ArrayList<MediaStore.Audio.Albums> = ArrayList()
}