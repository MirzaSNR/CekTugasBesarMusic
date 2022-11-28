package com.example.tugasbesarmusic

import android.provider.MediaStore

class MusicTrack {
    lateinit var name: String
    lateinit var ALbum: ArrayList<MusicTrack>
    lateinit var NameArtis: String
}
class MusicAlbum {
    var ref: ArrayList<MediaStore.Audio.Albums> = ArrayList()
}