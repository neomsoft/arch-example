package arch.exampleapp.data.api.facades

interface FactsNetworkFacade {

    suspend fun fact(): Result<String>
}