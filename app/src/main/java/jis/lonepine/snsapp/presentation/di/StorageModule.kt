package jis.lonepine.snsapp.presentation.di

import dagger.Binds
import dagger.Module
import jis.lonepine.snsapp.data.local.SharedPreferencesStorage
import jis.lonepine.snsapp.data.local.Storage

@Module
abstract class StorageModule
{
    @Binds
    abstract fun provideStorage(storage: SharedPreferencesStorage): Storage
}