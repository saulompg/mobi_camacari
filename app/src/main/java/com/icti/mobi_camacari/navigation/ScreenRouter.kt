package com.icti.mobi_camacari.navigation

sealed class Screen(val route : String) {
    object SignInScreen : Screen(route = "sign_in_screen")
    object SignUpScreen : Screen(route = "sign_up_screen")
    object TermsAndConditionsScreen : Screen(route = "terms_and_conditions_screen")
    object PrivacyPolicyScreen : Screen(route = "privacy_policy_screen")
    object HomeScreen : Screen(route = "home_screen")
}