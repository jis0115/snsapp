package jis.lonepine.snsapp.presentation.di

import dagger.Subcomponent
import jis.lonepine.snsapp.presentation.ui.card.CardFragment
import jis.lonepine.snsapp.presentation.ui.feed.FeedFragment
import jis.lonepine.snsapp.presentation.ui.home.HomeFragment
import jis.lonepine.snsapp.presentation.ui.main.MainActivity
import jis.lonepine.snsapp.presentation.ui.signin.SignInFragment
import jis.lonepine.snsapp.presentation.ui.userinfo.UserInfoFragment

@ActivityScope
@Subcomponent
interface UserInfoComponent
{
    @Subcomponent.Factory
    interface Factory{
        fun create():UserInfoComponent
    }
    fun inject(fragment: UserInfoFragment)
}