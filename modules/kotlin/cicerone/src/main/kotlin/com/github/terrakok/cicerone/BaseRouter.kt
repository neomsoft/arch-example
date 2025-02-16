package com.github.terrakok.cicerone

import kotlinx.coroutines.flow.Flow

/**
 * BaseRouter is an abstract class to implement high-level navigation.
 *
 * Extend it to add needed transition methods.
 */
abstract class BaseRouter {
    internal val commandBuffer = CommandBuffer()
    private val resultWire = ResultWire()

    fun resultFlow(key: String): Flow<Any> {
        return resultWire.resultFlow(key)
    }

    /**
     * Sends data to listener with given key.
     */
    fun sendResult(key: String, data: Any) {
        resultWire.sendResult(key, data)
    }

    /**
     * Sends navigation command array to [CommandBuffer].
     *
     * @param commands navigation command array to execute
     */
    protected fun executeCommands(vararg commands: Command) {
        commandBuffer.executeCommands(commands)
    }
}