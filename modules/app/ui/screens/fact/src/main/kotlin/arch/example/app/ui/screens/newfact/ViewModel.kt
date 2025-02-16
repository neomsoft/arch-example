package arch.example.app.ui.screens.newfact

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import arch.example.app.data.repositories.FactsRepository
import arch.example.app.ui.common.navigation.AppRouter
import io.github.neomsoft.coroutine.scope.owner.CoroutineScopeOwner
import io.github.neomsoft.flow.result.FlowResult
import io.github.neomsoft.flow.result.mapSuccessResult
import io.github.neomsoft.flow.result.onEachSuccessResult
import org.koin.android.annotation.KoinViewModel

@KoinViewModel(binds = [NewFactViewModel::class])
internal class NewFactViewModel(
    private val router: AppRouter,
    private val catFactsRepository: FactsRepository,
) : ViewModel(),
    CoroutineScopeOwner,
    ScreenCallback {

    override val scope = viewModelScope

    val state = catFactsRepository
        .newFact()
        .onEachSuccessResult { catFactsRepository.saveFact(it) }
        .mapSuccessResult { ScreenState(it) }
        .stateInEagerly(initialValue = FlowResult.Loading)

    override fun onBtnBackClick() {
        router.exit()
    }
}