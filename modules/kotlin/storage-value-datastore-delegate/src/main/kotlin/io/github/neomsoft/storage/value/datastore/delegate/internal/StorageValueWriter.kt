package io.github.neomsoft.storage.value.datastore.delegate.internal

import androidx.datastore.preferences.core.MutablePreferences
import androidx.datastore.preferences.core.Preferences

class StorageValueWriter internal constructor(
    private val preferences: MutablePreferences,
    private val keysHelper: KeysHelper,
) {

    fun boolean(keySuffix: String = "", value: Boolean?) {
        val preferencesKey = keysHelper.booleanKey(keySuffix)
        setOrRemove(preferencesKey = preferencesKey, value = value)
    }

    fun int(keySuffix: String = "", value: Int?) {
        val preferencesKey = keysHelper.intKey(keySuffix)
        setOrRemove(preferencesKey = preferencesKey, value = value)
    }

    fun long(keySuffix: String = "", value: Long?) {
        val preferencesKey = keysHelper.longKey(keySuffix)
        setOrRemove(preferencesKey = preferencesKey, value = value)
    }

    fun float(keySuffix: String = "", value: Float?) {
        val preferencesKey = keysHelper.floatKey(keySuffix)
        setOrRemove(preferencesKey = preferencesKey, value = value)
    }

    fun double(keySuffix: String = "", value: Double?) {
        val preferencesKey = keysHelper.doubleKey(keySuffix)
        setOrRemove(preferencesKey = preferencesKey, value = value)
    }

    fun string(keySuffix: String = "", value: String?) {
        val preferencesKey = keysHelper.stringKey(keySuffix)
        setOrRemove(preferencesKey = preferencesKey, value = value)
    }

    private fun <T> setOrRemove(preferencesKey: Preferences.Key<T>, value: T?) {
        if (value != null) {
            preferences[preferencesKey] = value
        } else {
            preferences.remove(preferencesKey)
        }
    }
}
