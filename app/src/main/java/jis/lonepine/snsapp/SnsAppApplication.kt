package jis.lonepine.snsapp

import androidx.multidex.MultiDexApplication
import jis.lonepine.snsapp.presentation.di.moduleList
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class SnsAppApplication:MultiDexApplication() {
    //dagger 가 익숙하지 않으니 선 개발 후 dagger converting 처리하는방향으로..
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@SnsAppApplication)
            modules(moduleList)
        }

    }
}