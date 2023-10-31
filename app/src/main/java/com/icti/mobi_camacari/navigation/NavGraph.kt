package com.icti.mobi_camacari.navigation

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.icti.mobi_camacari.data.api.Api
import com.icti.mobi_camacari.data.home.HomeViewModel
import com.icti.mobi_camacari.data.signIn.SignInViewModel
import com.icti.mobi_camacari.data.signUp.SignUpViewModel
import com.icti.mobi_camacari.ui.screens.*


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SetupNavGraph(
    navController : NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = Screen.SignInScreen.route
    ) {

        composable(
            route = Screen.SignInScreen.route
        ) {
            SignInScreen(
                navController = navController,
                signInViewModel = SignInViewModel(
                    navController = navController
                )
            )
        }

        composable(
            route = Screen.SignUpScreen.route
        ) {
            SignUpScreen(
                navController = navController,
                signUpViewModel = SignUpViewModel(
                    navController = navController
                )
            )
        }

        composable(
            route = Screen.TermsAndConditionsScreen.route
        ) {
            TermsAndConditionsScreen()
        }

        composable(
            route = Screen.PrivacyPolicyScreen.route
        ) {
            PrivacyPolicyScreen()
        }

        composable(
            route = Screen.HomeScreen.route
        ) {
            HomeScreen(
                navController = navController,
                homeViewModel = HomeViewModel(
                    navController = navController
                ),
                api = Api()
            )
        }

    }
}