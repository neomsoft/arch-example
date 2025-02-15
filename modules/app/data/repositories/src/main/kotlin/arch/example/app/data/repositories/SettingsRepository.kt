package arch.example.app.data.repositories

import arch.example.app.core.entities.theme.ThemeMode
import io.github.neomsoft.flow.result.FlowResult
import kotlinx.coroutines.flow.Flow

interface SettingsRepository {

    suspend fun onboardingShown(): Boolean

    suspend fun setOnboardingShown(shown: Boolean)

    fun themMode(): Flow<FlowResult<ThemeMode>>

    suspend fun setThemeMode(themeMode: ThemeMode)
}