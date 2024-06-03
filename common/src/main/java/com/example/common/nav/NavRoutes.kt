package com.example.common.nav

import androidx.navigation.NamedNavArgument
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavType
import androidx.navigation.navArgument
import com.example.common.nav.routes.CapsuleNavRoute


sealed class NavRoutes(
    val route: String,
    val arguments: List<NamedNavArgument> = emptyList()
) {
    data object Home : NavRoutes(ROUTE_HOME)
    object Capsule : NavRoutes(CapsuleNavRoute.Details.route, CapsuleNavRoute.Details.arguments)


    companion object {
        const val ROUTE_AUTH = "auth"
        const val ROUTE_HOME = "home"
        const val ROUTE_CAPSULES = "capsules"
        const val ROUTE_HISTORY = "history"
        const val ROUTE_LAUNCHES = "launches"
        const val ROUTE_MISSIONS = "missions"
        const val ROUTE_ROCKETS = "rockets"
        const val ROUTE_SHIPS = "ships"
    }
}