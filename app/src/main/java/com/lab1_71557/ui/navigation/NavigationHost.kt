package com.lab1_71557.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController

@Composable
fun NavigationHost(
    navController: NavHostController = rememberNavController(),
) {
    NavHost(
        navController = navController,
        startDestination = "login"){

        loginScreen(
            onNavigateToSignUp = {
                navController.navigateToSignUp()
            }
        )

        signUpScreen(
            onNavigateToLogin = {
                navController.navigateToLogin()
            }
        )
    }
}