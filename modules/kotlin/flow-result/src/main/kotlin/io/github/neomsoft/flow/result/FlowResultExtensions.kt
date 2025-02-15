package io.github.neomsoft.flow.result

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach

fun <T> T.toSuccessFlowResult(): FlowResult<T> = FlowResult.Success(data = this)

fun <T> Flow<FlowResult<T>>.onEachSuccessResult(
    action: suspend (T) -> Unit,
): Flow<FlowResult<T>> {
    return this.onEach { state ->
        state.onSuccess {
            action(it)
        }
    }
}

inline fun <T, R> Flow<FlowResult<T>>.mapSuccessResult(
    crossinline transform: suspend (T) -> R,
): Flow<FlowResult<R>> {
    return this.map {
        when (it) {
            is FlowResult.Loading -> it
            is FlowResult.Error -> it
            is FlowResult.Success -> FlowResult.Success(data = transform(it.data))
        }
    }
}

fun <T1, T2, R> Flow<FlowResult<T1>>.combineSuccessResult(
    flow: Flow<T2>,
    transform: suspend (T1, T2) -> R,
): Flow<FlowResult<R>> {
    return this.combine(flow) { result, data ->
        when (result) {
            is FlowResult.Loading -> result
            is FlowResult.Error -> result
            is FlowResult.Success -> FlowResult.Success(data = transform(result.data, data))
        }
    }
}

fun <T1, T2, R> Flow<FlowResult<T1>>.combineSuccessResults(
    flow: Flow<FlowResult<T2>>,
    transform: suspend (T1, T2) -> R,
): Flow<FlowResult<R>> {
    return this.combine(flow) { state1, state2 ->
        if (state1 is FlowResult.Error) return@combine state1
        if (state2 is FlowResult.Error) return@combine state2

        if (state1 is FlowResult.Success && state2 is FlowResult.Success) {
            val data = transform(state1.data, state2.data)
            return@combine FlowResult.Success(data = data)
        }

        FlowResult.Loading
    }
}

fun <T1, T2, T3, R> combineSuccessResults(
    flow1: Flow<FlowResult<T1>>,
    flow2: Flow<FlowResult<T2>>,
    flow3: Flow<FlowResult<T3>>,
    transform: suspend (T1, T2, T3) -> R,
): Flow<FlowResult<R>> {
    return combine(flow1, flow2, flow3) { state1, state2, state3 ->
        if (state1 is FlowResult.Error) return@combine state1
        if (state2 is FlowResult.Error) return@combine state2
        if (state3 is FlowResult.Error) return@combine state3

        if (state1 is FlowResult.Success &&
            state2 is FlowResult.Success &&
            state3 is FlowResult.Success
        ) {
            val data = transform(state1.data, state2.data, state3.data)
            return@combine FlowResult.Success(data = data)
        }

        FlowResult.Loading
    }
}

fun <T1, T2, T3, T4, R> combineSuccessResults(
    flow1: Flow<FlowResult<T1>>,
    flow2: Flow<FlowResult<T2>>,
    flow3: Flow<FlowResult<T3>>,
    flow4: Flow<FlowResult<T4>>,
    transform: suspend (T1, T2, T3, T4) -> R,
): Flow<FlowResult<R>> {
    return combine(flow1, flow2, flow3, flow4) { state1, state2, state3, state4 ->
        if (state1 is FlowResult.Error) return@combine state1
        if (state2 is FlowResult.Error) return@combine state2
        if (state3 is FlowResult.Error) return@combine state3
        if (state4 is FlowResult.Error) return@combine state4

        if (state1 is FlowResult.Success &&
            state2 is FlowResult.Success &&
            state3 is FlowResult.Success &&
            state4 is FlowResult.Success
        ) {
            val data = transform(state1.data, state2.data, state3.data, state4.data)
            return@combine FlowResult.Success(data = data)
        }

        FlowResult.Loading
    }
}

fun <T1, T2, T3, T4, T5, R> combineSuccessResults(
    flow1: Flow<FlowResult<T1>>,
    flow2: Flow<FlowResult<T2>>,
    flow3: Flow<FlowResult<T3>>,
    flow4: Flow<FlowResult<T4>>,
    flow5: Flow<FlowResult<T5>>,
    transform: suspend (T1, T2, T3, T4, T5) -> R,
): Flow<FlowResult<R>> {
    return combine(flow1, flow2, flow3, flow4, flow5) { state1, state2, state3, state4, state5 ->
        if (state1 is FlowResult.Error) return@combine state1
        if (state2 is FlowResult.Error) return@combine state2
        if (state3 is FlowResult.Error) return@combine state3
        if (state4 is FlowResult.Error) return@combine state4
        if (state5 is FlowResult.Error) return@combine state5

        if (state1 is FlowResult.Success &&
            state2 is FlowResult.Success &&
            state3 is FlowResult.Success &&
            state4 is FlowResult.Success &&
            state5 is FlowResult.Success
        ) {
            val data = transform(state1.data, state2.data, state3.data, state4.data, state5.data)
            return@combine FlowResult.Success(data = data)
        }

        FlowResult.Loading
    }
}

inline fun <reified T, R> combineSuccessResults(
    vararg flows: Flow<FlowResult<T>>,
    crossinline transform: suspend (Array<T>) -> R
): Flow<FlowResult<R>> {
    return combine(*flows) { states ->
        for (state in states) {
            if (state is FlowResult.Error) {
                return@combine state
            }
        }

        if (states.all { it is FlowResult.Success }) {
            val data = states.map { it as FlowResult.Success }.map { it.data }
            return@combine FlowResult.Success(data = transform(data.toTypedArray()))
        }

        FlowResult.Loading
    }
}

@OptIn(ExperimentalCoroutinesApi::class)
fun <T, R> Flow<FlowResult<T>>.flatMapLatestSuccessResult(
    transform: suspend (T) -> Flow<FlowResult<R>>,
): Flow<FlowResult<R>> {
    return this.flatMapLatest {
        when (it) {
            is FlowResult.Loading -> flowOf(it)
            is FlowResult.Error -> flowOf(it)
            is FlowResult.Success -> transform(it.data)
        }
    }
}