package vboyko.gb.libs.lesson1.presentation

import android.app.Application
import com.github.terrakok.cicerone.Cicerone
import com.github.terrakok.cicerone.Router
import vboyko.gb.libs.lesson1.di.*

class App : Application() {

    val appComponent: AppComponent = DaggerAppComponent.builder()
        .appModule(AppModule(this))
        .build()

    private var userSubcomponent: UsersSubcomponent? = null

    private var repositorySubcomponent: RepositorySubcomponent? = null

    fun initUserSubcomponent() = appComponent.userSubcomponent().also {
        userSubcomponent = it
    }

    fun initRepositorySubcomponent() = userSubcomponent?.reposSubcomponent().also {
        repositorySubcomponent = it
    }

    fun releaseUserScope() {
        userSubcomponent = null
    }

    fun releaseRepositoryScope() {
        repositorySubcomponent = null
    }
}