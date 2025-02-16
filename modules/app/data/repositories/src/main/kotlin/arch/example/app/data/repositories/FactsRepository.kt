package arch.example.app.data.repositories

import io.github.neomsoft.flow.result.FlowResult
import kotlinx.coroutines.flow.Flow

interface FactsRepository {

    fun newFact(): Flow<FlowResult<String>>

    suspend fun saveFact(fact: String)

    fun savedFacts(): Flow<FlowResult<List<String>>>
}