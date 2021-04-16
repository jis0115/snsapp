package jis.lonepine.snsapp.presentation.di

import dagger.Subcomponent
import jis.lonepine.snsapp.presentation.ui.card.CardFragment
import jis.lonepine.snsapp.presentation.ui.feed.FeedFragment
import jis.lonepine.snsapp.presentation.ui.home.HomeFragment
import jis.lonepine.snsapp.presentation.ui.main.MainActivity
import jis.lonepine.snsapp.presentation.ui.signin.SignInFragment

@ActivityScope
@Subcomponent
interface SignInComponent
{
    @Subcomponent.Factory
    interface Factory{
        fun create():SignInComponent
    }
    fun inject(fragment: SignInFragment)
}