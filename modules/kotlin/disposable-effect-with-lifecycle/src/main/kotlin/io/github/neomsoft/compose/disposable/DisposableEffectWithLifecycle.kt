package io.github.neomsoft.compose.disposable

import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.NonRestartableComposable
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.LifecycleOwner

@Composable
@NonRestartableComposable
fun DisposableEffectWithLifecycle(
    block: DisposableEffectWithLifecycleScope.() -> Unit,
) {
    val lifecycleOwner: LifecycleOwner = LocalLifecycleOwner.current

    DisposableEffect(Unit) {
        val scope = DisposableEffectWithLifecycleScope()
        block(scope)

        val observer = LifecycleEventObserver { _, event ->
            when (event) {
                Lifecycle.Event.ON_CREATE  -> scope.doOnCreate()
                Lifecycle.Event.ON_START   -> scope.doOnStart()
                Lifecycle.Event.ON_RESUME  -> scope.doOnResume()
                Lifecycle.Event.ON_PAUSE   -> scope.doOnPause()
                Lifecycle.Event.ON_STOP    -> scope.doOnStop()
                Lifecycle.Event.ON_DESTROY -> scope.doOnDestroy()
                Lifecycle.Event.ON_ANY     -> scope.doOnAny()
            }
        }

        lifecycleOwner.lifecycle.addObserver(observer)

        onDispose {
            lifecycleOwner.lifecycle.removeObserver(observer)
            scope.doOnDispose()
        }
    }
}