package com.ndt.WallpaperMonth.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.ndt.WallpaperMonth.databinding.ItemWallpaperBinding
import com.ndt.WallpaperMonth.model.Wallpaper

class WallpaperAdapter(private var wallpapers: ArrayList<Wallpaper>) : BaseAdapter() {
    override fun getCount(): Int = wallpapers.size


    override fun getItem(position: Int): Any =  wallpapers[position]

    override fun getItemId(position: Int): Long = position.toLong()

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var holder: ViewHolder
        var view: View? = convertView
        if (view == null) {
            val binding = ItemWallpaperBinding.inflate(LayoutInflater.from(parent?.context))
            holder = ViewHolder()
            view = binding.root
            holder.imgWallpaper = binding.imgWallpaper
            holder.tvName = binding.tvName
            holder.tvMonth = binding.tvMonth
            view.tag = holder
        } else {
            holder = view.tag as ViewHolder
        }

        var wallpaper = wallpapers[position]

        Glide.with(view).load(wallpaper.image).into(holder.imgWallpaper)
        holder.tvName.text = wallpaper.name
        holder.tvMonth.text = wallpaper.month

        return view
    }

    class ViewHolder() {
        lateinit var imgWallpaper: ImageView
        lateinit var tvMonth: TextView
        lateinit var tvName: TextView
    }
}