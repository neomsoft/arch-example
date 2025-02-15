package io.github.neomsoft.storage.value.datastore.delegate

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import io.github.neomsoft.storage.value.StorageValue
import io.github.neomsoft.storage.value.datastore.delegate.internal.KeysHelper
import io.github.neomsoft.storage.value.datastore.delegate.internal.StorageValueReader
import io.github.neomsoft.storage.value.datastore.delegate.internal.StorageValueWriter
import kotlin.properties.ReadOnlyProperty
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.map

fun <T> DataStore<Preferences>.property(
    saver: StorageValueSaver<T>,
): ReadOnlyProperty<Any, StorageValue<T>> {
    val dataStore = this

    return ReadOnlyProperty { thisRef, property ->
        object : StorageValue<T> {
            val prefix = thisRef::class.qualifiedName + '_' + property.name
            val keysHelper = KeysHelper(prefix = prefix)

            override suspend fun set(value: T) {
                dataStore.edit {
                    val writer = StorageValueWriter(preferences = it, keysHelper = keysHelper)
                    saver.save(writer = writer, value = value)
                }
            }

            override fun observe() = dataStore.data
                .map {
                    val reader = StorageValueReader(preferences = it, keysHelper = keysHelper)
                    saver.restore(reader = reader)
                }
                .distinctUntilChanged()
        }
    }
}

fun <T> DataStore<Preferences>.property(
    save: StorageValueWriter.(value: T) -> Unit,
    restore: StorageValueReader.() -> T,
): ReadOnlyProperty<Any, StorageValue<T>> {
    return property(
        saver = object : StorageValueSaver<T> {
            override fun save(writer: StorageValueWriter, value: T) = writer.save(value)
            override fun restore(reader: StorageValueReader) = reader.restore()
        }
    )
}

fun DataStore<Preferences>.booleanProperty(
    defaultValue: Boolean = false,
): ReadOnlyProperty<Any, StorageValue<Boolean>> {
    return property(
        save = { boolean(value = it) },
        restore = { boolean() ?: defaultValue }
    )
}

fun DataStore<Preferences>.intProperty(
    defaultValue: Int = 0,
): ReadOnlyProperty<Any, StorageValue<Int>> {
    return property(
        save = { int(value = it) },
        restore = { int() ?: defaultValue }
    )
}

fun DataStore<Preferences>.longProperty(
    defaultValue: Long = 0,
): ReadOnlyProperty<Any, StorageValue<Long>> {
    return property(
        save = { long(value = it) },
        restore = { long() ?: defaultValue }
    )
}

fun DataStore<Preferences>.doubleProperty(
    defaultValue: Double = 0.0,
): ReadOnlyProperty<Any, StorageValue<Double>> {
    return property(
        save = { double(value = it) },
        restore = { double() ?: defaultValue }
    )
}

fun DataStore<Preferences>.floatProperty(
    defaultValue: Float = 0f,
): ReadOnlyProperty<Any, StorageValue<Float>> {
    return property(
        save = { float(value = it) },
        restore = { float() ?: defaultValue }
    )
}

fun DataStore<Preferences>.stringProperty(
    defaultValue: String = "",
): ReadOnlyProperty<Any, StorageValue<String>> {
    return property(
        save = { string(value = it) },
        restore = { string() ?: defaultValue }
    )
}

fun DataStore<Preferences>.nullableStringProperty(
    //
): ReadOnlyProperty<Any, StorageValue<String?>> {
    return property(
        save = { string(value = it) },
        restore = { string() }
    )
}
