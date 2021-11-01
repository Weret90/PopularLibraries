package vboyko.gb.libs.lesson1.domain

class GetImagePNGUseCase(private val repository: InternalStorageRepository) {

    fun execute() = repository.getImagePNG()
}