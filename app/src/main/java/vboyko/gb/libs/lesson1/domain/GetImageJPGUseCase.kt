package vboyko.gb.libs.lesson1.domain

class GetImageJPGUseCase(private val repository: InternalStorageRepository) {

    fun execute() = repository.getImageJPG()
}