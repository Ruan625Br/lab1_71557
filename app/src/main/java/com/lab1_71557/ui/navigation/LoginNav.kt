package com.lab1_71557.ui.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.lab1_71557.ui.screens.bLogin

const val LoginRoute = "login"

fun NavGraphBuilder.loginScreen(
 onNavigateToSignUp: () -> Unit
) {
    composable(route = LoginRoute) {
        bLogin(onNavigateToSignUp = onNavigateToSignUp
        )
    }
}

fun NavController.navigateToLogin(){
    navigate(LoginRoute)
}