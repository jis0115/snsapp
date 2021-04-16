package jis.lonepine.snsapp.presentation.di

import dagger.Module

//@Module(subcomponents = [RegistrationComponent::class,LoginComponent::class, UserComponent::class ])
@Module(subcomponents = [ MainComponent::class,CardComponent::class,UserInfoComponent::class,SignInComponent::class,SignUpComponent::class])
class AppSubcomponents