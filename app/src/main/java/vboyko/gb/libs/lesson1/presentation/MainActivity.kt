package vboyko.gb.libs.lesson1.presentation

import android.graphics.Bitmap
import android.os.Bundle
import android.view.View
import android.widget.Toast
import moxy.MvpAppCompatActivity
import moxy.ktx.moxyPresenter
import vboyko.gb.libs.lesson1.data.InternalStorageRepositoryImpl
import vboyko.gb.libs.lesson1.databinding.ActivityMainBinding

class MainActivity : MvpAppCompatActivity(), IScreenConvertToPNG {

    private lateinit var binding: ActivityMainBinding

    private val presenter: ConvertToPNGPresenter by moxyPresenter {
        ConvertToPNGPresenter(InternalStorageRepositoryImpl(this))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        presenter.getImageJPG()
    }

    override fun showImageJPG(bitmap: Bitmap) {

        binding.imageJPG.setImageBitmap(bitmap)

        binding.btnConvertToPng.setOnClickListener {
            presenter.convertImageToPNG(bitmap)
        }
    }

    override fun showImagePNG(bitmap: Bitmap) {
        binding.imagePNG.setImageBitmap(bitmap)
    }

    override fun showImagePNGLabel() {
        binding.pngImageLabel.visibility = View.VISIBLE
    }

    override fun showError(errorMessage: String?) {
        Toast.makeText(this, errorMessage, Toast.LENGTH_LONG).show()
    }
}