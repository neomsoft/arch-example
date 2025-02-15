package arch.example.app.data.database.storages

interface FactsStorage {

    suspend fun facts(): List<String>

    suspend fun saveFact(fact: String)
}