package vboyko.gb.libs.lesson1.di

import com.github.terrakok.cicerone.Cicerone
import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.Router
import dagger.Binds
import dagger.Module
import dagger.Provides
import vboyko.gb.libs.lesson1.presentation.AndroidScreens
import vboyko.gb.libs.lesson1.presentation.interfaces.Screens
import javax.inject.Singleton

@Module
class CiceroneModule {

    @Singleton
    @Provides
    fun provideCicerone(): Cicerone<Router> {
        return Cicerone.create()
    }

    @Singleton
    @Provides
    fun provideRouter(cicerone: Cicerone<Router>): Router {
        return cicerone.router
    }

    @Singleton
    @Provides
    fun provideNavHolder(cicerone: Cicerone<Router>): NavigatorHolder {
        return cicerone.getNavigatorHolder()
    }

    @Singleton
    @Provides
    fun provideScreens(): Screens {
        return AndroidScreens()
    }
}