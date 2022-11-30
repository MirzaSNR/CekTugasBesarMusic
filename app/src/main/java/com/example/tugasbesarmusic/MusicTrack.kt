package com.example.tugasbesarmusic

import android.provider.MediaStore
import java.sql.Time


class MusicTrack {
    lateinit var  id: String
    lateinit var title: String
    lateinit var album: ArrayList<MusicTrack>
    lateinit var artist: String
    lateinit var path: String
    lateinit var duration: Time
}
class MusicAlbum {
    var ref: ArrayList<MediaStore.Audio.Albums> = ArrayList()
}