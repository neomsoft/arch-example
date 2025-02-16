package io.github.neomsoft.navigation.compose.destination

import androidx.compose.runtime.Composable
import androidx.navigation.NamedNavArgument
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavDeepLink

abstract class Destination(
    private val name: String,
    internal val arguments: List<NamedNavArgument> = emptyList(),
    internal val deepLinks: List<NavDeepLink> = emptyList(),
    internal val isDialog: Boolean = false,
) {
    private val requiredArgs = arguments
        .filterNot { it.argument.isNullable }
        .map { it.name }

    private val optionalArgs = arguments
        .filter { it.argument.isNullable }
        .map { it.name }

    internal val route =
        name + requiredArgs.toRequiredRoutePart() + optionalArgs.toOptionalRoutePart()

    @Composable
    internal fun drawScreen(navBackStackEntry: NavBackStackEntry) {
        onDrawScreen(navBackStackEntry = navBackStackEntry)
    }

    @Composable
    protected abstract fun onDrawScreen(navBackStackEntry: NavBackStackEntry)

    protected fun route(argumentNameValues: Map<String, String> = emptyMap()): String {
        checkArguments(argumentNameValues)

        val optionalRoutePart = argumentNameValues.keys
            .filter { optionalArgs.contains(it) }
            .toOptionalRoutePart()

        var routeWithAvailableArgs = name + requiredArgs.toRequiredRoutePart() + optionalRoutePart

        argumentNameValues.forEach { (name, value) ->
            routeWithAvailableArgs = routeWithAvailableArgs.replace("{$name}", value)
        }

        return routeWithAvailableArgs
    }

    private fun checkArguments(argumentNameValues: Map<String, String>) {
        val requiredArgsKeys = argumentNameValues.keys.filter { optionalArgs.contains(it).not() }
        val unknownKeys = requiredArgsKeys - requiredArgs.toSet()

        if (unknownKeys.isNotEmpty()) {
            throw IllegalArgumentException("Arguments [${unknownKeys.joinToString()}] are not registered")
        }
    }

    private fun List<String>.toRequiredRoutePart() = this
        .joinToString(separator = "/") { "{$it}" }
        .let { if (it.isEmpty()) "" else "/$it" }

    private fun Iterable<String>.toOptionalRoutePart() = this
        .joinToString(separator = "&") { "$it={$it}" }
        .let { if (it.isEmpty()) "" else "?$it" }
}
