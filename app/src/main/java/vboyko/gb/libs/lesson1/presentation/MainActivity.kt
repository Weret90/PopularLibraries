package vboyko.gb.libs.lesson1.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import vboyko.gb.libs.lesson1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), MainView {

    private lateinit var binding: ActivityMainBinding

    private val presenter = MainPresenter(this)

    companion object {
        private const val ARG_BUTTON_1_TEXT = "arg_button_1_text"
        private const val ARG_BUTTON_2_TEXT = "arg_button_2_text"
        private const val ARG_BUTTON_3_TEXT = "arg_button_3_text"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupCLickListeners()
    }

    private fun setupCLickListeners() {
        binding.btnCounter1.setOnClickListener {
            presenter.updateCounterOnButton(ButtonNum.FIRST)
        }
        binding.btnCounter2.setOnClickListener {
            presenter.updateCounterOnButton(ButtonNum.SECOND)
        }
        binding.btnCounter3.setOnClickListener {
            presenter.updateCounterOnButton(ButtonNum.THIRD)
        }
    }

    override fun setTextOnButton(buttonNum: ButtonNum, text: String) {
        when (buttonNum) {
            ButtonNum.FIRST -> binding.btnCounter1.text = text
            ButtonNum.SECOND -> binding.btnCounter2.text = text
            ButtonNum.THIRD -> binding.btnCounter3.text = text
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(ARG_BUTTON_1_TEXT, binding.btnCounter1.text.toString())
        outState.putString(ARG_BUTTON_2_TEXT, binding.btnCounter2.text.toString())
        outState.putString(ARG_BUTTON_3_TEXT, binding.btnCounter3.text.toString())
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        binding.btnCounter1.text = savedInstanceState.getString(ARG_BUTTON_1_TEXT)
        binding.btnCounter2.text = savedInstanceState.getString(ARG_BUTTON_2_TEXT)
        binding.btnCounter3.text = savedInstanceState.getString(ARG_BUTTON_3_TEXT)
    }
}