package io.github.neomsoft.storage.value.datastore.delegate.internal

import androidx.datastore.preferences.core.Preferences

class StorageValueReader internal constructor(
    private val preferences: Preferences,
    private val keysHelper: KeysHelper,
) {

    fun boolean(keySuffix: String = ""): Boolean? {
        val preferencesKey = keysHelper.booleanKey(keySuffix)
        return preferences[preferencesKey]
    }

    fun int(keySuffix: String = ""): Int? {
        val preferencesKey = keysHelper.intKey(keySuffix)
        return preferences[preferencesKey]
    }

    fun long(keySuffix: String = ""): Long? {
        val preferencesKey = keysHelper.longKey(keySuffix)
        return preferences[preferencesKey]
    }

    fun float(keySuffix: String = ""): Float? {
        val preferencesKey = keysHelper.floatKey(keySuffix)
        return preferences[preferencesKey]
    }

    fun double(keySuffix: String = ""): Double? {
        val preferencesKey = keysHelper.doubleKey(keySuffix)
        return preferences[preferencesKey]
    }

    fun string(keySuffix: String = ""): String? {
        val preferencesKey = keysHelper.stringKey(keySuffix)
        return preferences[preferencesKey]
    }
}
