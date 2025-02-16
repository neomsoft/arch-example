package arch.example.app.data.repositories.impl

import arch.example.app.data.database.storages.FactsStorage
import arch.example.app.data.repositories.FactsRepository
import arch.exampleapp.data.api.facades.FactsNetworkFacade
import io.github.neomsoft.flow.result.FlowResult
import kotlinx.coroutines.flow.flow
import org.koin.core.annotation.Single

@Single(binds = [FactsRepository::class])
internal class FactsRepositoryImpl(
    private val factsNetworkFacade: FactsNetworkFacade,
    private val factsStorage: FactsStorage,
) : FactsRepository {

    override fun newFact() = flow {
        val result = factsNetworkFacade.fact()

        result.onSuccess {
            emit(FlowResult.Success(it))
        }

        result.onFailure {
            emit(FlowResult.Error(it))
        }
    }

    override suspend fun saveFact(fact: String) {
        factsStorage.saveFact(fact)
    }

    override fun savedFacts() = flow {
        val result = FlowResult.runCatching { factsStorage.facts() }
        emit(result)
    }
}