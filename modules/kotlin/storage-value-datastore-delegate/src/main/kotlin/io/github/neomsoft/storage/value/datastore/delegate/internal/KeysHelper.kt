package io.github.neomsoft.storage.value.datastore.delegate.internal

import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.doublePreferencesKey
import androidx.datastore.preferences.core.floatPreferencesKey
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.core.longPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey

internal class KeysHelper(private val prefix: String) {

    fun booleanKey(keySuffix: String): Preferences.Key<Boolean> =
        booleanPreferencesKey(rawKey(keySuffix))

    fun intKey(keySuffix: String): Preferences.Key<Int> =
        intPreferencesKey(rawKey(keySuffix))

    fun longKey(keySuffix: String): Preferences.Key<Long> =
        longPreferencesKey(rawKey(keySuffix))

    fun floatKey(keySuffix: String): Preferences.Key<Float> =
        floatPreferencesKey(rawKey(keySuffix))

    fun doubleKey(keySuffix: String): Preferences.Key<Double> =
        doublePreferencesKey(rawKey(keySuffix))

    fun stringKey(keySuffix: String): Preferences.Key<String> =
        stringPreferencesKey(rawKey(keySuffix))

    private fun rawKey(key: String) =
        prefix + key
}
