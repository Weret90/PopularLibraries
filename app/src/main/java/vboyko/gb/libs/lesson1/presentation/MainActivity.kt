package vboyko.gb.libs.lesson1.presentation

import android.os.Bundle
import com.github.terrakok.cicerone.androidx.AppNavigator
import moxy.MvpAppCompatActivity
import moxy.ktx.moxyPresenter
import vboyko.gb.libs.lesson1.R
import vboyko.gb.libs.lesson1.databinding.ActivityMainBinding
import vboyko.gb.libs.lesson1.presentation.interfaces.BackButtonListener
import vboyko.gb.libs.lesson1.presentation.interfaces.MainView
import vboyko.gb.libs.lesson1.presentation.presenters.MainPresenter

class MainActivity : MvpAppCompatActivity(), MainView {

    private val navigator = AppNavigator(this, R.id.container)

    private lateinit var binding: ActivityMainBinding
    private val presenter by moxyPresenter { MainPresenter(App.instance.router, AndroidScreens()) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onResumeFragments() {
        super.onResumeFragments()
        App.instance.navigatorHolder.setNavigator(navigator)
    }

    override fun onPause() {
        super.onPause()
        App.instance.navigatorHolder.removeNavigator()
    }

    override fun onBackPressed() {
        supportFragmentManager.fragments.forEach {
            if (it is BackButtonListener && it.backPressed()) {
                return
            }
        }
        presenter.backClicked()
    }
}