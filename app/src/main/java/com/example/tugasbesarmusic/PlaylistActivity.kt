//cek
//package com.example.tugasbesarmusic
//
//class PlaylistActivity : AppCompatActivity() {
//    lateinit var gridPlaylistAdapter: GridPlaylistAdapter
//    private lateinit var list: ArrayList<String>
//    companion object {
//        var musicPlayList: MusicPlaylist = MusicPlaylist()
//    }
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_playlist)
//        list = ArrayList<String>()
//        list.add("Playlist 1")
//        list.add("Playlist 2")
//        list.add("Playlist 3")
//        list.add("Playlist 4")
//        list.add("Playlist 5")
//        showRecyclerGrid()
//        fab_add.setOnClickListener {
//            customDialog()
//
//        }
//    }
//    private fun showRecyclerGrid() {
//        rv_grid_track.layoutManager =
//            GridLayoutManager(this@PlaylistActivity, 2)
//        gridPlaylistAdapter = GridPlaylistAdapter(this, playlistList =
//        musicPlayList.ref)
//        rv_grid_track.adapter = gridPlaylistAdapter
//    }
//    private fun customDialog() {
//        val builder = AlertDialog.Builder(
//            this,
//            com.google.android.material.R.style.ThemeOverlay_MaterialComponents_Material
//                    AlertDialog_Centered
//        )
//            .create()
//        val view = layoutInflater.inflate(R.layout.add_playlist_dialog,
//            null)
//        builder.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
//        builder.requestWindowFeature(Window.FEATURE_NO_TITLE)
//        builder.setView(view)
//        builder.show()
//        val batal = builder.findViewById<TextView>(R.id.btn_batal)
//        val ok = builder.findViewById<TextView>(R.id.btn_ok)
//        val pl_name = builder.findViewById<EditText>(R.id.et_name_pl).text
//        val uname = builder.findViewById<EditText>(R.id.et_uname_pl).text
//        ok.setOnClickListener {
//            if (pl_name != null && uname != null) {
//                addPlaylist(pl_name.toString(), uname.toString())
//
//                builder.dismiss()
//
//            }
//        }
//        batal.setOnClickListener {
//            builder.dismiss()
//        }
//        builder.setCanceledOnTouchOutside(false)
//    }
//    private fun addPlaylist(name: String, uname: String) {
//        var playlistExists = false
//        for (i in musicPlayList.ref) {
//            if (name.equals(i.name)) {
//                playlistExists = true
//                break
//            }
//        }
//        if (playlistExists) Toast.makeText(this, "Playlist Sudah Ada",
//            Toast.LENGTH_SHORT).show()
//        else {
//            val tempPL = Playlist()
//            tempPL.name = name
//            tempPL.createdBy = uname
//
//            tempPL.playlist = ArrayList()
//            val calendar = Calendar.getInstance().time
//            val sdf = SimpleDateFormat("dd MM yyyy", Locale.ENGLISH)
//            tempPL.createdOn = sdf.format(calendar)
//            musicPlayList.ref.add(tempPL)
//            gridPlaylistAdapter.refreshPlaylist()
//        }
//    }
//}