package io.github.neomsoft.coroutine.scope.owner

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn

interface CoroutineScopeOwner {

    val scope: CoroutineScope

    fun <T> Flow<T>.stateInEagerly(initialValue: T): StateFlow<T> {
        return stateIn(
            initialValue = initialValue,
            scope = scope,
            started = SharingStarted.Eagerly,
        )
    }

    fun <T> Flow<T>.stateInLazily(initialValue: T): StateFlow<T> {
        return stateIn(
            initialValue = initialValue,
            scope = scope,
            started = SharingStarted.Lazily,
        )
    }
}