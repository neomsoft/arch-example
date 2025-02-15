package io.github.neomsoft.flow.result

sealed class FlowResult<out T> {

    data class Success<T>(val data: T) : FlowResult<T>()

    data class Error(val exception: Throwable) : FlowResult<Nothing>()

    data object Loading : FlowResult<Nothing>()

    companion object {

        inline fun <T> runCatching(block: () -> T): FlowResult<T> {
            return try {
                Success(block())
            } catch (exception: Throwable) {
                Error(exception)
            }
        }
    }
}

val FlowResult<*>.isSuccess: Boolean get() = this is FlowResult.Success

val FlowResult<*>.isFailure: Boolean get() = this is FlowResult.Error

val FlowResult<*>.isLoading: Boolean get() = this is FlowResult.Loading

fun <T> FlowResult<T>.dataOrNull(): T? = (this as? FlowResult.Success)?.data

fun <T> FlowResult<T>.exceptionOrNull() = (this as? FlowResult.Error)?.exception

fun <T> FlowResult<T>.dataOrDefault(defaultValue: T): T {
    return when (this) {
        is FlowResult.Success -> data
        is FlowResult.Error -> defaultValue
        is FlowResult.Loading -> defaultValue
    }
}

inline fun <R, T> FlowResult<T>.map(transform: (value: T) -> R): FlowResult<R> {
    return when (this) {
        is FlowResult.Success -> FlowResult.Success(transform(data))
        is FlowResult.Error -> this
        is FlowResult.Loading -> this
    }
}

inline fun <T> FlowResult<T>.onSuccess(action: (T) -> Unit): FlowResult<T> {
    if (this is FlowResult.Success) {
        action(data)
    }

    return this
}

inline fun <T> FlowResult<T>.onLoading(action: () -> Unit): FlowResult<T> {
    if (this is FlowResult.Loading) {
        action()
    }

    return this
}

inline fun <T> FlowResult<T>.onFailure(action: (Throwable) -> Unit): FlowResult<T> {
    if (this is FlowResult.Error) {
        action(exception)
    }

    return this
}