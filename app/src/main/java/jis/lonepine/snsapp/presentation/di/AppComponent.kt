package jis.lonepine.snsapp.presentation.di

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import jis.lonepine.snsapp.presentation.ui.card.CardFragment
import jis.lonepine.snsapp.presentation.ui.feed.FeedFragment
import jis.lonepine.snsapp.presentation.ui.home.HomeFragment
import jis.lonepine.snsapp.presentation.ui.main.MainActivity
import jis.lonepine.snsapp.presentation.ui.signin.SignInFragment
import jis.lonepine.snsapp.presentation.ui.signup.SignUpFragment
import jis.lonepine.snsapp.presentation.ui.userinfo.UserInfoFragment
import javax.inject.Singleton

@Singleton
@Component(modules = [NetworkModule::class,StorageModule::class,AppSubcomponents::class])
interface AppComponent
{
    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context): AppComponent
    }

    fun mainComponent():MainComponent.Factory
    fun cardComponent():CardComponent.Factory
    fun signInComponent():SignInComponent.Factory
    fun signUpComponent():SignUpComponent.Factory
    fun userInfoComponent():UserInfoComponent.Factory

}