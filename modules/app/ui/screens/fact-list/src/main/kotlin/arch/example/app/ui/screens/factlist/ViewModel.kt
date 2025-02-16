package arch.example.app.ui.screens.factlist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import arch.example.app.data.repositories.FactsRepository
import arch.example.app.ui.common.navigation.AppRouter
import io.github.neomsoft.coroutine.scope.owner.CoroutineScopeOwner
import io.github.neomsoft.flow.result.FlowResult
import io.github.neomsoft.flow.result.mapSuccessResult
import org.koin.android.annotation.KoinViewModel

@KoinViewModel(binds = [FactListViewModel::class])
internal class FactListViewModel(
    private val router: AppRouter,
    factsRepository: FactsRepository,
) : ViewModel(),
    CoroutineScopeOwner,
    ScreenCallback {

    override val scope = viewModelScope

    val state = factsRepository
        .savedFacts()
        .mapSuccessResult { ScreenState(it) }
        .stateInEagerly(initialValue = FlowResult.Loading)


    override fun onBtnBackClick() {
        router.exit()
    }
}