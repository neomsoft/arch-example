package io.github.neomsoft.storage.value.datastore.delegate

import io.github.neomsoft.storage.value.datastore.delegate.internal.StorageValueReader
import io.github.neomsoft.storage.value.datastore.delegate.internal.StorageValueWriter

interface StorageValueSaver<T> {
    fun save(writer: StorageValueWriter, value: T)
    fun restore(reader: StorageValueReader): T
}