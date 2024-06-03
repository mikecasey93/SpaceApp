package com.example.spaceapp

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.common.nav.NavRoutes
import com.example.common.nav.routes.CapsuleNavRoute
import com.example.spaceapp.ui.compose.firebase.LoginScreen
import com.example.spaceapp.ui.compose.firebase.signOut
import com.example.spaceapp.ui.compose.home.HomeScreen
import com.example.spaceapp.ui.compose.screens.capsules.CapsuleDetailsScreen
import com.example.spaceapp.ui.theme.SpaceAppTheme
import com.google.firebase.auth.FirebaseAuth
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SpaceAppTheme {
                val navController = rememberNavController()
                SpaceApp(navController = navController)
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SpaceApp(navController: NavHostController) {
    val topState = remember { mutableStateOf(false) }
    val bottomState = remember { mutableStateOf(true) }
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navController.currentBackStackEntry?.destination?.route
    val barTitle = remember(currentRoute) {
        when (currentRoute) {
            NavRoutes.ROUTE_CAPSULES -> "Capsules"
            NavRoutes.Capsule.route -> "Capsule Details"
            else -> "Details"
        }
    }

    when (navBackStackEntry?.destination?.route) {
        NavRoutes.Home.route,
        NavRoutes.Home.route -> {
            bottomState.value = true
            topState.value = false
        }
        NavRoutes.ROUTE_AUTH -> {
            bottomState.value = false
            topState.value = false
        }
        else -> {
            bottomState.value = false
            topState.value = true
        }
    }

    Scaffold(
        topBar = {
            if (topState.value) {
                TopAppBar(
                    title = { Text(barTitle) },
                    //backgroundColor = MaterialTheme.colorScheme.primary,
                    navigationIcon = {
                        IconButton(onClick = { navController.popBackStack() }) {
                            Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Back")
                        }
                    }
                )
            }
        },
        bottomBar = {
            if (bottomState.value) {
                BottomAppBar(navController)
            }
        }
    ) {innerPadding ->
        NavHost(
            navController = navController,
            startDestination = NavRoutes.ROUTE_AUTH,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(NavRoutes.ROUTE_AUTH) {
                LoginScreen(navController = navController)
            }
            composable(NavRoutes.Home.route) {
                HomeScreen(navController = navController)
            }
            composable(
                route = NavRoutes.Capsule.route,
                arguments = NavRoutes.Capsule.arguments
            ) {
                CapsuleDetailsScreen(CapsuleNavRoute.Details.fromEntry(it))
            }
        }

    }
}

@Composable
fun BottomAppBar(navController: NavHostController) {
    val auth = FirebaseAuth.getInstance()
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp)
            .background(MaterialTheme.colorScheme.primary)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.End
        ) {
            Icon(
                painter = painterResource(R.drawable.baseline_logout_24),
                contentDescription = null,
                modifier = Modifier
                    .clickable { signOut(auth, navController) }
            )
        }
    }
}

