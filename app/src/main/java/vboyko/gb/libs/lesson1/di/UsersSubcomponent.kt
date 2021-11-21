package vboyko.gb.libs.lesson1.di

import dagger.Subcomponent
import vboyko.gb.libs.lesson1.presentation.fragments.UserDetailFragment
import vboyko.gb.libs.lesson1.presentation.fragments.UserRepoDetailFragment
import vboyko.gb.libs.lesson1.presentation.fragments.UsersListFragment

@UsersScope
@Subcomponent(
    modules = [UsersModule::class]
)
interface UsersSubcomponent {
    fun reposSubcomponent(): RepositorySubcomponent
    fun inject(usersListFragment: UsersListFragment)
}


