package com.ndt.WallpaperMonth.model

import java.io.Serializable

data class Wallpaper(var image: Int,
                     var month: String,
                     var name: String) : Serializable