package vboyko.gb.libs.lesson1.di

import dagger.Subcomponent
import vboyko.gb.libs.lesson1.presentation.fragments.UserDetailFragment
import vboyko.gb.libs.lesson1.presentation.fragments.UserRepoDetailFragment

@ReposScope
@Subcomponent(
    modules = [ReposModule::class]
)
interface RepositorySubcomponent {
    fun inject(userDetailFragment: UserDetailFragment)
    fun inject(userRepoDetailFragment: UserRepoDetailFragment)
}

