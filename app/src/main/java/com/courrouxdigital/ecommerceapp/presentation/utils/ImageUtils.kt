package com.courrouxdigital.ecommerceapp.presentation.utils

import android.content.Context
import android.net.Uri
import androidx.core.content.FileProvider
import java.io.File
import java.io.FileOutputStream

object ImageUtils {
    fun createImageUri(context: Context): Uri {
        val imagesDir = File(context.cacheDir, "images")
        imagesDir.mkdirs()

        val imageFile = File.createTempFile(
            "photo_",
            ".jpg",
            imagesDir
        )

        val authority = "${context.packageName}.fileprovider"

        return FileProvider.getUriForFile(
            context,
            authority,
            imageFile
        )
    }

    fun uriToFile(context: Context, uri: Uri): File {
        val inputStream = context.contentResolver.openInputStream(uri)!!
        val file = File(context.cacheDir, "temp_image_${System.currentTimeMillis()}.jpg")
        val outputStream = FileOutputStream(file)

        inputStream.copyTo(outputStream)
        inputStream.close()
        outputStream.close()

        return file
    }
}
