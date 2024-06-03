package com.example.common.nav.routes
import android.net.Uri
import androidx.navigation.NamedNavArgument
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavType
import androidx.navigation.navArgument
import com.google.gson.Gson

sealed class CapsuleNavRoute(
    val route: String,
    val arguments: List<NamedNavArgument> = emptyList()
) {
    data object Details : CapsuleNavRoute(
        route = "$ROUTE_CAPSULE_DETAILS/{$ARG_CAPSULE_INFO}",
        arguments = listOf(
            navArgument(ARG_CAPSULE_INFO) {
                type = NavType.StringType
            }
        )
    ) {
        fun routeForCapsule(input: CapsuleInput): String {
            val json = Uri.encode(input.toJson())
            return "$ROUTE_CAPSULE_DETAILS/$json"
        }

        fun fromEntry(entry: NavBackStackEntry): CapsuleInput {
            val json = entry.arguments?.getString(ARG_CAPSULE_INFO) ?: ""
            return CapsuleInput.fromJson(json)
        }
    }

    companion object {
        const val ROUTE_CAPSULE_DETAILS = "capsuleDetails"
        const val ARG_CAPSULE_INFO = "capsule_info"
    }
}

data class CapsuleInput(
    val capsuleSerial: String?,
    val details: String?,
    val landings: Int?,
    val originalLaunch: String?,
    val status: String?
) {
    fun toJson(): String {
        return Gson().toJson(this)
    }

    companion object {
        fun fromJson(json: String): CapsuleInput {
            return Gson().fromJson(json, CapsuleInput::class.java)
        }
    }
}