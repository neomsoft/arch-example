package arch.example.app.ui.common.navigation

import kotlinx.coroutines.flow.Flow

interface AppRouter {

    fun navigateTo(screen: Screens)

    fun newRootScreen(screen: Screens)

    fun exit()

    fun observeResult(key: String): Flow<Any>

    fun sendResult(key: String, data: Any)
}