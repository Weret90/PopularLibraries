package vboyko.gb.libs.lesson1.presentation

import android.graphics.Bitmap
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import moxy.MvpPresenter
import vboyko.gb.libs.lesson1.domain.ConvertJPGToPNGUseCase
import vboyko.gb.libs.lesson1.domain.GetImageJPGUseCase
import vboyko.gb.libs.lesson1.domain.GetImagePNGUseCase
import vboyko.gb.libs.lesson1.domain.InternalStorageRepository

class ConvertToPNGPresenter(repository: InternalStorageRepository) :
    MvpPresenter<IScreenConvertToPNG>() {

    private val getImageJPGUseCase = GetImageJPGUseCase(repository)
    private val getImagePNGUseCase = GetImagePNGUseCase(repository)
    private val convertJPGToPNGUseCase = ConvertJPGToPNGUseCase(repository)

    fun getImageJPG() {
        getImageJPGUseCase.execute()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {
                    viewState.showImageJPG(it)
                },
                {
                    viewState.showError(it.message)
                }
            )
    }

    fun convertImageToPNG(bitmap: Bitmap) {
        convertJPGToPNGUseCase.execute(bitmap)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {
                    getImagePNG()
                },
                {
                    viewState.showError(it.message)
                }
            )
    }

    private fun getImagePNG() {
        getImagePNGUseCase.execute()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {
                    viewState.showImagePNG(it)
                    viewState.showImagePNGLabel()
                },
                {
                    viewState.showError(it.message)
                }
            )
    }
}