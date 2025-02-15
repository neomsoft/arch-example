package arch.example.app.data.database.storages

import arch.example.app.data.database.daos.FactsDao
import arch.example.app.data.database.entities.FactEntity

internal class FactsStorageImpl(
    private val factsDao: FactsDao,
) : FactsStorage {

    override suspend fun facts(): List<String> {
        return factsDao.fats().map { it.fact }
    }

    override suspend fun saveFact(fact: String) {
        val entity = FactEntity(fact = fact)
        factsDao.insert(entity)
    }
}