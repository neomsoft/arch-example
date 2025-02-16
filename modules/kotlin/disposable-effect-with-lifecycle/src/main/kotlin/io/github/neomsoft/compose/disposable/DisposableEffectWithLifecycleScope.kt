package io.github.neomsoft.compose.disposable

class DisposableEffectWithLifecycleScope {

    internal var doOnCreate  : () -> Unit = {}
    internal var doOnStart   : () -> Unit = {}
    internal var doOnResume  : () -> Unit = {}
    internal var doOnPause   : () -> Unit = {}
    internal var doOnStop    : () -> Unit = {}
    internal var doOnDestroy : () -> Unit = {}
    internal var doOnAny     : () -> Unit = {}
    internal var doOnDispose : () -> Unit = {}

    fun onCreate(block: () -> Unit) {
        doOnCreate = block
    }

    fun onStart(block: () -> Unit) {
        doOnStart = block
    }

    fun onResume(block: () -> Unit) {
        doOnResume = block
    }

    fun onPause(block: () -> Unit) {
        doOnPause = block
    }

    fun onStop(block: () -> Unit) {
        doOnStop = block
    }

    fun onDestroy(block: () -> Unit) {
        doOnDestroy = block
    }

    fun onAny(block: () -> Unit) {
        doOnAny = block
    }

    fun onDispose(block: () -> Unit) {
        doOnDispose = block
    }
}