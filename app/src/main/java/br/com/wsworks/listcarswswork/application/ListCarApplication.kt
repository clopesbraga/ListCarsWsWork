package br.com.wsworks.listcarswswork.application

import android.app.Application
import br.com.wsworks.listcarswswork.module.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext.startKoin

class ListCarApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@ListCarApplication)
            modules(appModule)
        }
    }


}