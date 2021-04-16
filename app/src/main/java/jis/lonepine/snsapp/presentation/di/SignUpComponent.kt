package jis.lonepine.snsapp.presentation.di

import dagger.Subcomponent
import jis.lonepine.snsapp.presentation.ui.card.CardFragment
import jis.lonepine.snsapp.presentation.ui.feed.FeedFragment
import jis.lonepine.snsapp.presentation.ui.home.HomeFragment
import jis.lonepine.snsapp.presentation.ui.main.MainActivity
import jis.lonepine.snsapp.presentation.ui.signin.SignInFragment
import jis.lonepine.snsapp.presentation.ui.signup.SignUpFragment

@ActivityScope
@Subcomponent
interface SignUpComponent
{
    @Subcomponent.Factory
    interface Factory{
        fun create():SignUpComponent
    }
    fun inject(fragment: SignUpFragment)
}