package arch.example.app.ui.screens.onboarding

import androidx.lifecycle.ViewModel
import arch.example.app.data.repositories.SettingsRepository
import arch.example.app.ui.common.navigation.AppRouter
import arch.example.app.ui.common.navigation.Screens
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.koin.android.annotation.KoinViewModel

@KoinViewModel(binds = [OnboardingViewModel::class])
internal class OnboardingViewModel(
    private val router: AppRouter,
    private val settingsRepository: SettingsRepository,
) : ViewModel(),
    ScreenCallback {

    @OptIn(DelicateCoroutinesApi::class)
    override fun onBtnSkipClick() {
        GlobalScope.launch {
            settingsRepository.setOnboardingShown(true)
        }

        router.newRootScreen(Screens.Main)
    }
}