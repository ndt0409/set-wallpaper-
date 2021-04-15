package com.ndt.WallpaperMonth

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.BaseAdapter
import com.ndt.WallpaperMonth.adapter.WallpaperAdapter
import com.ndt.WallpaperMonth.databinding.ActivityMainBinding
import com.ndt.WallpaperMonth.model.Wallpaper

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: BaseAdapter
    private var wallpapers = arrayListOf<Wallpaper>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        adapter = WallpaperAdapter(wallpapers)
        binding.gvWallpaper.adapter = adapter

        wallpapers.add(Wallpaper(R.drawable.january, "January", "Tu"))
        wallpapers.add(Wallpaper(R.drawable.february, "February", "Tu"))
        wallpapers.add(Wallpaper(R.drawable.march, "March", "Tu"))
        wallpapers.add(Wallpaper(R.drawable.april, "April", "Tu"))
        wallpapers.add(Wallpaper(R.drawable.june, "June", "Tu"))
        wallpapers.add(Wallpaper(R.drawable.july, "July", "Tu"))
        wallpapers.add(Wallpaper(R.drawable.august, "August", "Tu"))
        wallpapers.add(Wallpaper(R.drawable.may, "May", "Tu"))
        wallpapers.add(Wallpaper(R.drawable.september, "September", "Tu"))
        wallpapers.add(Wallpaper(R.drawable.october, "October", "Tu"))
        wallpapers.add(Wallpaper(R.drawable.november, "November", "Tu"))
        wallpapers.add(Wallpaper(R.drawable.december, "December", "Tu"))

        adapter.notifyDataSetChanged()
        binding.gvWallpaper.setOnItemClickListener { adapterView, view, i, l ->
            val wallpaper = wallpapers[i]
            val intent = Intent(this, WallpaperActivity::class.java)
            val bundle = Bundle()
            bundle.putSerializable("wallpaper", wallpaper)
            intent.putExtras(bundle)
            startActivity(intent)
        }
    }
}