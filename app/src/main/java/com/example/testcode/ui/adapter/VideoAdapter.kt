package com.example.testcode.ui.adapter

import android.content.Context
import android.graphics.BitmapFactory
import android.os.Environment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.testcode.R
import com.example.testcode.utils.VideoDownloader
import java.io.File

class VideoAdapter(private val context: Context, private val videoUrls: List<String>) :
    RecyclerView.Adapter<VideoAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_video, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val videoUrl = videoUrls[position]
        // Download video and display it
        val videoDownloader = VideoDownloader()
        val fileName = "video_$position.mp4"
        videoDownloader.downloadVideo(videoUrl, fileName)
        val filePath = "${Environment.DIRECTORY_DOWNLOADS}/$fileName"

            val videoBitmap = BitmapFactory.decodeFile(filePath)
            holder.videoImageView.setImageBitmap(videoBitmap)


    }

    override fun getItemCount(): Int {
        return videoUrls.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val videoImageView: ImageView = itemView.findViewById(R.id.videoImageView)
    }
}
