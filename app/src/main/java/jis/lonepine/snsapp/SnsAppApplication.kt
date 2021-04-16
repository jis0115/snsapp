package jis.lonepine.snsapp

import androidx.multidex.MultiDexApplication
import jis.lonepine.snsapp.presentation.di.AppComponent
import jis.lonepine.snsapp.presentation.di.DaggerAppComponent

class SnsAppApplication:MultiDexApplication() {
    val appComponent: AppComponent by lazy {
        initializeComponent()
    }

    fun initializeComponent(): AppComponent {
        return DaggerAppComponent.factory().create(applicationContext)
    }
}