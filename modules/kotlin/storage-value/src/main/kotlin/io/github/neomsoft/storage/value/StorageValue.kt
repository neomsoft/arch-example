package io.github.neomsoft.storage.value

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first

interface StorageValue<T> {

    fun observe(): Flow<T>

    suspend fun set(value: T)
}

suspend fun <T> StorageValue<T>.get(): T = observe().first()