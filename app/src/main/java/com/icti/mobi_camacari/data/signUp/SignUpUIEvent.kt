package com.icti.mobi_camacari.data.signUp

sealed class SignUpUIEvent {


    data class FirstNameChanged(val firstName: String): SignUpUIEvent()
    data class LastNameChanged(val lastName: String): SignUpUIEvent()
    data class EmailChanged(val email: String): SignUpUIEvent()
    data class PhoneChanged(val phone: String): SignUpUIEvent()
    data class PasswordChanged(val password: String): SignUpUIEvent()
    data class ConfirmPasswordChanged(val confirmPassword: String): SignUpUIEvent()
    data class PrivacyPolicyCheckBoxClicked(val status: Boolean): SignUpUIEvent()
    object SignUpButtonClicked: SignUpUIEvent()
}