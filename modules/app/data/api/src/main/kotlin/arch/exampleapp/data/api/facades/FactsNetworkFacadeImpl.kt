package arch.exampleapp.data.api.facades

import arch.exampleapp.data.api.FactsAppApi
import org.koin.core.annotation.Single

@Single(binds = [FactsNetworkFacade::class])
internal class FactsNetworkFacadeImpl(
    private val api: FactsAppApi,
) : FactsNetworkFacade {

    override suspend fun fact(): Result<String> {
        return api.fact().map { it.fact }
    }
}