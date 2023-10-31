package com.icti.mobi_camacari.data.signUp

data class SignUpUIState(

    var firstName: String = "",
    var lastName: String = "",
    var email: String = "",
    var phone: String = "",
    var password: String = "",
    var confirmPassword: String = "",
    var privacyPolicyAccepted: Boolean = false,

    var firstNameError: Boolean = true,
    var lastNameError: Boolean = true,
    var emailError: Boolean = true,
    var phoneError: Boolean = true,
    var passwordError: Boolean = true,
    var confirmPasswordError: Boolean = true,
    var privacyPolicyError: Boolean = false

)