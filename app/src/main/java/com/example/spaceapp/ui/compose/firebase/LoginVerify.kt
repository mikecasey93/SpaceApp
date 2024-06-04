package com.example.spaceapp.ui.compose.firebase
import android.content.Context
import android.widget.Toast
import androidx.navigation.NavHostController
import com.google.firebase.auth.FirebaseAuth
import com.example.common.nav.NavRoutes

fun isVerifiedUser(
    email: String,
    password: String,
    auth: FirebaseAuth,
    context: Context,
    navController: NavHostController
) {
    auth.signInWithEmailAndPassword(email, password)
        .addOnCompleteListener { task ->
            if (task.isSuccessful) {
                navController.navigate(NavRoutes.Home.route)
            }
            else {
                Toast.makeText(context, "Authentication failed", Toast.LENGTH_SHORT).show()
            }
        }
}

fun checkStatus(auth: FirebaseAuth, navController: NavHostController) {
    val currentUser = auth.currentUser
    if (currentUser != null) {
        navController.navigate(NavRoutes.Home.route) {
            popUpTo(NavRoutes.Home.route) { inclusive = true }
        }
    }
}

fun signUp(email: String,
           password: String,
           confirmPassword: String,
           auth: FirebaseAuth,
           context: Context,
           signUpSuccess: () -> Unit
) {
    if (password != confirmPassword) {
        Toast.makeText(context, "Incorrect Password", Toast.LENGTH_SHORT).show()
        return
    }

    auth.createUserWithEmailAndPassword(email, password)
        .addOnCompleteListener { task ->
            if (task.isSuccessful) {
                Toast.makeText(context, "Success", Toast.LENGTH_SHORT).show()
                signUpSuccess()
            } else {
                Toast.makeText(context, "Failed: ${task.exception?.message}", Toast.LENGTH_SHORT).show()
            }
        }
}


fun signOut(auth: FirebaseAuth, navController: NavHostController) {
    auth.signOut()
    navController.navigate(NavRoutes.ROUTE_AUTH)
}