package arch.example.app.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import arch.example.app.data.database.daos.FactsDao
import arch.example.app.data.database.entities.FactEntity
import kotlinx.coroutines.Dispatchers
import org.koin.mp.KoinPlatform.getKoin

@Database(
    entities = [
        FactEntity::class,
    ],
    version = 1,
)
internal abstract class AppDatabase : RoomDatabase() {

    abstract fun factsDao(): FactsDao

    companion object {
        const val DATABASE_FILE_NAME = "database.db"
    }
}

internal fun createAppDatabase(databaseName: String): AppDatabase {
    val context: Context = getKoin().get()
    val dbFile = context.getDatabasePath(databaseName)

    return Room.databaseBuilder<AppDatabase>(context, dbFile.absolutePath)
        .setDriver(BundledSQLiteDriver())
        .setQueryCoroutineContext(Dispatchers.IO)
        .build()
}