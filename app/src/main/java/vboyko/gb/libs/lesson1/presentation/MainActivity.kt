package vboyko.gb.libs.lesson1.presentation

import android.os.Bundle
import moxy.MvpAppCompatActivity
import vboyko.gb.libs.lesson1.databinding.ActivityMainBinding

class MainActivity : MvpAppCompatActivity(), MainView {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}