package com.lab1_71557.ui.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.lab1_71557.ui.screens.gSignUp

const val SignUpRoute = "signUp"

fun NavGraphBuilder.signUpScreen(
    onNavigateToLogin: () -> Unit
){
    composable(route = SignUpRoute){
        gSignUp(
            onNavigateToLogin = onNavigateToLogin
        )
    }
}

fun NavController.navigateToSignUp(){
    navigate(SignUpRoute)
}