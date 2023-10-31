package com.icti.mobi_camacari.data.signIn

sealed class SignInUIEvent {

    data class EmailChanged(val email: String): SignInUIEvent()
    data class PasswordChanged(val password: String): SignInUIEvent()
    object LoginButtonClicked: SignInUIEvent()

}