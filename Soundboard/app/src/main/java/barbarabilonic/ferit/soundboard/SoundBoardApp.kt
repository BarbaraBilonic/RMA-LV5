package barbarabilonic.ferit.soundboard

import android.app.Application
import barbarabilonic.ferit.soundboard.di.appModule
import barbarabilonic.ferit.soundboard.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class SoundBoardApp : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@SoundBoardApp)
            modules(appModule, viewModelModule)
        }
    }

}