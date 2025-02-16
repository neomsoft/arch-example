package arch.example.app.ui.screens.main

import androidx.compose.runtime.Stable

@Stable
interface ScreenCallback {
    fun onBtnGetNewFactClick()
    fun onBtnFactListClick()
}