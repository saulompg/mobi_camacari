package com.icti.mobi_camacari.data.rules

import android.util.Log
import java.util.regex.Matcher
import java.util.regex.Pattern

object Validator {

    fun validateFirstName(firstName: String) : ValidationResult {
        return ValidationResult(
            status = firstName.isNotBlank() && firstName.length >= 2
        )
    }
    fun validateLastName(lastName: String) : ValidationResult {
        return ValidationResult(
            status = lastName.isNotBlank() && lastName.length >= 2
        )
    }
    fun validateEmail(email: String) : ValidationResult {
        return ValidationResult(
            status = isValidRegex(expression = emailRegex , value = email)
        )
    }
    fun validatePhone(phone: String) : ValidationResult {
        return ValidationResult(
            status = isValidRegex(expression = phoneRegex , value = phone)
        )
    }
    fun validatePassword(password: String) : ValidationResult {
        return ValidationResult(
            status = isValidRegex(expression = passwordRegex, value = password)
        )
    }
    fun validateConfirmPassword(password: String, confirmPassword: String) : ValidationResult {
        return ValidationResult(
            status = (confirmPassword == password) && confirmPassword.isNotBlank()
        )
    }
    fun validatePrivacyPolicy(privacyPolicyAccepted: Boolean) : ValidationResult {
        return ValidationResult(
            status = privacyPolicyAccepted
        )
    }

    // Regex
    private const val emailRegex = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$"
    private const val phoneRegex = "^(?:[14689][1-9]|2[12478]|3[1234578]|5[1345]|7[134579])9[1-9][0-9]{7}$"
    private const val passwordRegex = "^(?=.*\\d)(?=.*[A-Z])(?=.*[a-z])(?=.*[!#@$%&=+-_])(?=.*[0-9]).{6,20}$"

    // Verificação com o Regex
    private fun isValidRegex(expression : String, value : String) : Boolean {

        var isValid = false // inicializa uma variável auxiliar com o valor False

        if(value.isNotBlank()) { // verifica se a string não é nula nem está vazia

            val pattern : Pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE)	// Compila a expressão em um padrão
            val matcher : Matcher = pattern.matcher(value);									// Objeto que recebe a String a ser comparada e o padrão definido

            if(matcher.matches()) {
                isValid = true; // caso a string coincida com o padrão, a variável recebe o valor True
            }

        }

        return isValid; // retorna o valor da variável auxiliar

    }

}

data class ValidationResult(val status : Boolean = false)