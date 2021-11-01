package vboyko.gb.libs.lesson1.domain

import android.graphics.Bitmap

class ConvertJPGToPNGUseCase(private val repository: InternalStorageRepository) {

    fun execute(bitmap: Bitmap) = repository.convertJPGtoPNG(bitmap)
}