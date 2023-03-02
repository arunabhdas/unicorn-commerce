package app.unicornapp.mobile.android.unicorn

import android.app.Application
import timber.log.Timber
/**
 * MyApplication
 */

class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        if(BuildConfig.DEBUG){
            Timber.plant(Timber.DebugTree())
        }
    }
}