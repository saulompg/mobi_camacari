@file:OptIn(ExperimentalMaterial3Api::class)

package com.icti.mobi_camacari.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.icti.mobi_camacari.R
import com.icti.mobi_camacari.data.signIn.*
import com.icti.mobi_camacari.navigation.Screen
import com.icti.mobi_camacari.ui.components.*

@Composable
fun SignInScreen(navController: NavController, signInViewModel: SignInViewModel = viewModel()) {

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Surface(
            color = Color.White,
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
                .padding(28.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                // cabeçalho
                NormalTextComponent(value = stringResource(id = R.string.title_hello))
                HeadingTextComponent(value = stringResource(id = R.string.title_welcome))
                // adiciona um espaçador
                Spacer(modifier = Modifier.height(20.dp))
                // adiciona o campo de email
                EmailTextFieldComponent(
                    labelText = stringResource(id = R.string.email),
                    painterResource = painterResource(id = R.drawable.message),
                    onTextSelected = {
                        signInViewModel.onEvent(SignInUIEvent.EmailChanged(it))
                    },
                    errorStatus = signInViewModel.loginUIState.value.emailError
                )
                // adiciona o campo de senha
                PasswordTextFieldComponent(
                    labelText = stringResource(id = R.string.password),
                    painterResource = painterResource(id = R.drawable.lock),
                    onTextSelected = {
                        signInViewModel.onEvent(SignInUIEvent.PasswordChanged(it))
                    },
                    errorStatus = signInViewModel.loginUIState.value.passwordError
                )
                // adiciona um espaçador
                Spacer(modifier = Modifier.height(20.dp))
                // adiciona a opção para recuperar a senha
                UnderLineTextComponent(value = stringResource(id = R.string.forgot_password))
                // adiciona um espaçador
                Spacer(modifier = Modifier.height(20.dp))
                // adiciona o botão de login
                ButtonComponent(
                    value = stringResource(id = R.string.sign_in),
                    onButtonClicked = {
                        signInViewModel.onEvent(SignInUIEvent.LoginButtonClicked)
                    }
                )
                // adiciona o divisor
                DividerTextComponent()
                // adiciona opção para cadastrar novo usuario
                ClickableLoginTextComponent(
                    tryingToLog = false,
                    onTextSelected =  {
                        navController.navigate(route = Screen.SignUpScreen.route)
                    }
                )
            }
        }

        if(signInViewModel.loginInProgress.value) {
            CircularProgressIndicator()
        }

    }

}

@Preview
@Composable
fun SignInScreenPreview() {
    SignInScreen(navController = rememberNavController())
}