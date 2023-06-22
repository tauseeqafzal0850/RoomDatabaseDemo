package com.example.testcode.utils

import android.os.Environment
import java.io.BufferedInputStream
import java.io.File
import java.io.FileOutputStream
import java.net.URL

class VideoDownloader {

    fun downloadVideo(videoUrl: String, fileName: String): Boolean {
        try {
            val url = URL(videoUrl)
            val connection = url.openConnection()
            connection.connect()

            val input = BufferedInputStream(url.openStream())
            val storageDir = Environment.getExternalStorageDirectory()
            val file = File(storageDir, fileName)
            val output = FileOutputStream(file)

            val data = ByteArray(1024)
            var bytesRead: Int

            while (input.read(data).also { bytesRead = it } != -1) {
                output.write(data, 0, bytesRead)
            }

            output.flush()
            output.close()
            input.close()

            return true
        } catch (e: Exception) {
            // Handle network error or file error
            e.printStackTrace()
            return false
        }
    }
}

