package arch.example

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import arch.example.app.data.repositories.SettingsRepository
import io.github.neomsoft.coroutine.scope.owner.CoroutineScopeOwner
import io.github.neomsoft.flow.result.FlowResult
import io.github.neomsoft.flow.result.combineSuccessResults
import io.github.neomsoft.flow.result.toSuccessFlowResult
import kotlinx.coroutines.flow.flow
import org.koin.android.annotation.KoinViewModel

@KoinViewModel
internal class ComposeAppViewModel(
    private val settingsRepository: SettingsRepository,
) : ViewModel(), CoroutineScopeOwner {

    override val scope = viewModelScope

    private val themeModeState = settingsRepository
        .themMode()
        .stateInEagerly(initialValue = FlowResult.Loading)

    private val onboardingShownState = flow {
        val onboardingShown = settingsRepository.onboardingShown()
        emit(onboardingShown.toSuccessFlowResult())
    }
        .stateInEagerly(initialValue = FlowResult.Loading)

    val state = themeModeState
        .combineSuccessResults(onboardingShownState) { themeMode, onboardingShown ->
            ComposeAppState(
                onboardingShown = onboardingShown,
                themeMode = themeMode,
            )
        }
        .stateInEagerly(initialValue = FlowResult.Loading)
}