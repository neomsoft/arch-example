package arch.example.app.data.repositories.impl

import arch.example.app.core.entities.theme.ThemeMode
import arch.example.app.data.preferences.LocalPreferences
import arch.example.app.data.repositories.SettingsRepository
import io.github.neomsoft.flow.result.FlowResult
import io.github.neomsoft.flow.result.toSuccessFlowResult
import io.github.neomsoft.storage.value.get
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onStart
import org.koin.core.annotation.Single

@Single(binds = [SettingsRepository::class])
internal class SettingsRepositoryImpl(
    private val preferences: LocalPreferences,
) : SettingsRepository {

    override suspend fun onboardingShown(): Boolean {
        return preferences.onboardingShown.get()
    }

    override suspend fun setOnboardingShown(shown: Boolean) {
        preferences.onboardingShown.set(shown)
    }

    override fun themMode(): Flow<FlowResult<ThemeMode>> {
        return preferences
            .themeMode
            .observe()
            .map { it.toSuccessFlowResult() }
            .onStart { emit(FlowResult.Loading) }
    }

    override suspend fun setThemeMode(themeMode: ThemeMode) {
        preferences.themeMode.set(themeMode)
    }
}