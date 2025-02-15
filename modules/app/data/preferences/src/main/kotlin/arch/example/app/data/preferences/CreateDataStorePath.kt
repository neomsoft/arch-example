package arch.example.app.data.preferences

import android.content.Context
import org.koin.mp.KoinPlatform.getKoin

internal fun createDataStorePath(fileName: String): String {
    val context: Context = getKoin().get()
    return context.applicationContext.filesDir.resolve(fileName).absolutePath
}