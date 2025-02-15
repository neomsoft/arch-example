package arch.example.app.data.preferences

import arch.example.app.core.entities.theme.ThemeMode
import io.github.neomsoft.storage.value.StorageValue

interface LocalPreferences {

    val onboardingShown: StorageValue<Boolean>

    val themeMode: StorageValue<ThemeMode>
}