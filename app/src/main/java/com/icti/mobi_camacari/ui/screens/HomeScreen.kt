package com.icti.mobi_camacari.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.icti.mobi_camacari.R
import com.icti.mobi_camacari.data.api.Api
import com.icti.mobi_camacari.data.home.HomeViewModel
import com.icti.mobi_camacari.ui.components.ButtonComponent
import com.icti.mobi_camacari.ui.components.HeadingTextComponent
import com.icti.mobi_camacari.ui.components.NormalTextComponent

@Composable
fun HomeScreen(navController: NavController, homeViewModel: HomeViewModel, api: Api) {
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(28.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {

            HeadingTextComponent(value = stringResource(R.string.app_name))

            Spacer(modifier = Modifier.heightIn(200.dp))

            NormalTextComponent(value = "Informações pessoais")
            ButtonComponent(
                value = "acessar",
                onButtonClicked = {
                    api.getUsers()
                }
            )

            Spacer(modifier = Modifier.heightIn(200.dp))
            
            ButtonComponent(
                value = stringResource(R.string.logout),
                onButtonClicked = {
                    homeViewModel.logout()
                }
            )

        }

    }
}

@Preview
@Composable
fun HomeScreenPreview() {
    HomeScreen(
        navController = rememberNavController(),
        homeViewModel = HomeViewModel(
            navController = rememberNavController()
        ),
        api = Api()
    )
}