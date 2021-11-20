package vboyko.gb.libs.lesson1.presentation

import android.app.Application
import com.github.terrakok.cicerone.Cicerone
import com.github.terrakok.cicerone.Router
import vboyko.gb.libs.lesson1.di.AppComponent
import vboyko.gb.libs.lesson1.di.AppModule
import vboyko.gb.libs.lesson1.di.DaggerAppComponent

class App : Application() {

    val appComponent: AppComponent = DaggerAppComponent.builder()
        .appModule(AppModule(this))
        .build()
}