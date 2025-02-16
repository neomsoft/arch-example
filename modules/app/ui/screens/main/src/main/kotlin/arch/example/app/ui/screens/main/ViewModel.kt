package arch.example.app.ui.screens.main

import androidx.lifecycle.ViewModel
import arch.example.app.ui.common.navigation.AppRouter
import arch.example.app.ui.common.navigation.Screens
import org.koin.android.annotation.KoinViewModel

@KoinViewModel(binds = [MainViewModel::class])
internal class MainViewModel(
    private val router: AppRouter,
) : ViewModel(),
    ScreenCallback {

    override fun onBtnGetNewFactClick() {
        router.navigateTo(Screens.NewFact)
    }

    override fun onBtnFactListClick() {
        router.navigateTo(Screens.FactList)
    }
}