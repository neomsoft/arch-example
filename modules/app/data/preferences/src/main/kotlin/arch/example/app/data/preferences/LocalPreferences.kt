package arch.example.app.data.preferences

import io.github.neomsoft.storage.value.StorageValue

interface LocalPreferences {

    val onboardingShown: StorageValue<Boolean>
}