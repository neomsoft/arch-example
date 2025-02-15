package arch.example

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.component.KoinComponent
import org.koin.dsl.KoinAppDeclaration

class App: Application(), KoinComponent {

    override fun onCreate() {
        super.onCreate()

        val koinPlatformConfig: KoinAppDeclaration = {
            androidLogger()
            androidContext(this@App)
        }

        initApp(koinPlatformConfig = koinPlatformConfig)
    }
}