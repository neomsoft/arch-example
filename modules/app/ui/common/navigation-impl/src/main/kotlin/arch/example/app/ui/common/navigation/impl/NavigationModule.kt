package arch.example.app.ui.common.navigation.impl

import arch.example.app.ui.common.navigation.AppRouter
import org.koin.core.annotation.Single

internal val appRouter = AppRouterImpl()

@Single
internal fun provideAppRouter(): AppRouter = appRouter