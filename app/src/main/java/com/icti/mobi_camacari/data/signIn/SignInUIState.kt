package com.icti.mobi_camacari.data.signIn

data class SignInUIState (
    var email: String = "",
    var password: String = "",

    var emailError: Boolean = true,
    var passwordError: Boolean = true
)