package com.github.terrakok.cicerone

import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.onCompletion

internal class ResultWire {

    private val resultFlows = mutableMapOf<String, MutableSharedFlow<Any?>>()

    fun sendResult(key: String, data: Any) {
        resultStateFlow(key).tryEmit(value = data)
    }

    fun resultFlow(key: String): Flow<Any> {
        return resultStateFlow(key)
            .filterNotNull()
            .onCompletion { resultFlows.remove(key) }
    }

    private fun resultStateFlow(key: String): MutableSharedFlow<Any?> {
        return resultFlows.getOrPut(key) {
            MutableSharedFlow(
                replay = 1,
                onBufferOverflow = BufferOverflow.DROP_OLDEST,
            )
        }
    }
}