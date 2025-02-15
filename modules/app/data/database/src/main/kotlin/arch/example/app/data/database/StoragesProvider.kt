package arch.example.app.data.database

import arch.example.app.data.database.storages.FactsStorage
import arch.example.app.data.database.storages.FactsStorageImpl
import org.koin.core.annotation.Single

internal class StoragesProvider(
    val factsStorage: FactsStorage,
)

@Single
internal fun storagesProvider(): StoragesProvider {
    val appDatabase = createAppDatabase(AppDatabase.DATABASE_FILE_NAME)

    val factsStorage = FactsStorageImpl(
        factsDao = appDatabase.factsDao(),
    )

    return StoragesProvider(
        factsStorage = factsStorage,
    )
}

@Single
internal fun provideFactsStorage(provider: StoragesProvider) = provider.factsStorage