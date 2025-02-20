package arch.example.app.data.preferences

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.PreferenceDataStoreFactory
import androidx.datastore.preferences.core.Preferences
import arch.example.app.data.preferences.savers.ThemeModeSaver
import io.github.neomsoft.storage.value.datastore.delegate.booleanProperty
import io.github.neomsoft.storage.value.datastore.delegate.property
import okio.Path.Companion.toPath
import org.koin.core.annotation.Single

private class LocalPreferencesImpl(dataStore: DataStore<Preferences>) : LocalPreferences {

    override val onboardingShown by dataStore.booleanProperty()
    override val themeMode by dataStore.property(ThemeModeSaver())

    companion object {
        const val DATASTORE_FILE_NAME: String = "datastore.preferences_pb"
    }
}

@Single
internal fun createLocalPreferences(): LocalPreferences {
    val dataStorePath = createDataStorePath(LocalPreferencesImpl.DATASTORE_FILE_NAME)
    val produceFile = { dataStorePath.toPath() }
    val dataStore =  PreferenceDataStoreFactory.createWithPath(produceFile = produceFile)

    return LocalPreferencesImpl(dataStore  = dataStore)
}