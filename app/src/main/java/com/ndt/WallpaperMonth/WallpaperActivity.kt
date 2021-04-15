package com.ndt.WallpaperMonth

import android.app.WallpaperManager
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.ndt.WallpaperMonth.databinding.ActivityWallpaperBinding
import com.ndt.WallpaperMonth.model.Wallpaper

class WallpaperActivity : AppCompatActivity() {
    private lateinit var binding: ActivityWallpaperBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWallpaperBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val wallpaper = intent.getSerializableExtra("wallpaper") as Wallpaper
        binding.imgWallpaper.setImageResource(wallpaper.image)
        binding.tvName.text = wallpaper.name
        binding.tvMonth.text = wallpaper.month

        binding.imgBack.setOnClickListener {
            finish()
        }

        binding.btnSet.setOnClickListener {
            val image: Int = wallpaper.image
            val wallpaper: WallpaperManager = WallpaperManager.getInstance(applicationContext)
            wallpaper.setResource(image)
            Toast.makeText(this, "Success", Toast.LENGTH_SHORT).show()
        }
    }
}
