package vboyko.gb.libs.lesson1.presentation

import android.graphics.Bitmap
import moxy.MvpView
import moxy.viewstate.strategy.alias.AddToEndSingle

@AddToEndSingle
interface IScreenConvertToPNG : MvpView {

    fun showImageJPG(bitmap: Bitmap)

    fun showImagePNG(bitmap: Bitmap)

    fun showImagePNGLabel()

    fun showError(errorMessage: String?)
}