package vboyko.gb.libs.lesson1.di

import dagger.Component
import vboyko.gb.libs.lesson1.presentation.MainActivity
import vboyko.gb.libs.lesson1.presentation.fragments.UserDetailFragment
import vboyko.gb.libs.lesson1.presentation.fragments.UserRepoDetailFragment
import vboyko.gb.libs.lesson1.presentation.fragments.UsersListFragment
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class, CiceroneModule::class, RetrofitModule::class, RoomModule::class])
interface AppComponent {

    fun inject(mainActivity: MainActivity)
    fun userSubcomponent() : UsersSubcomponent
}