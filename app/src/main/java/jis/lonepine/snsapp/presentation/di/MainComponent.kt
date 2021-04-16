package jis.lonepine.snsapp.presentation.di

import dagger.Subcomponent
import jis.lonepine.snsapp.presentation.ui.feed.FeedFragment
import jis.lonepine.snsapp.presentation.ui.home.HomeFragment
import jis.lonepine.snsapp.presentation.ui.main.MainActivity

@ActivityScope
@Subcomponent
interface MainComponent
{
    @Subcomponent.Factory
    interface Factory{
        fun create():MainComponent
    }

    fun inject(activity: MainActivity)
    fun inject(fragment: HomeFragment)
    fun inject(fragment: FeedFragment)
}