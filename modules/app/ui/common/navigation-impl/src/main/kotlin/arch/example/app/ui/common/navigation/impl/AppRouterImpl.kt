package arch.example.app.ui.common.navigation.impl

import arch.example.app.ui.common.navigation.AppRouter
import arch.example.app.ui.common.navigation.Screens
import com.github.terrakok.cicerone.Cicerone
import com.github.terrakok.cicerone.Router

internal class AppRouterImpl(
    internal val cicerone: Cicerone<Router> = Cicerone.create(),
) : AppRouter {

    private val router = cicerone.router

    override fun navigateTo(screen: Screens) = router.navigateTo(screen.asComposeScreen())

    override fun newRootScreen(screen: Screens) = router.newRootScreen(screen.asComposeScreen())

    override fun exit() = router.exit()

    override fun observeResult(key: String) = router.resultFlow(key)

    override fun sendResult(key: String, data: Any) = router.sendResult(key = key, data = data)
}