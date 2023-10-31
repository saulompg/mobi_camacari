package com.icti.mobi_camacari.data.home

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import com.google.firebase.auth.FirebaseAuth
import com.icti.mobi_camacari.navigation.Screen

class HomeViewModel(var navController: NavController): ViewModel() {

    companion object {
        private val TAG = HomeViewModel::class.simpleName
    }

    fun logout() {
        FirebaseAuth
            .getInstance()
            .signOut()
        val authStateListener = FirebaseAuth.AuthStateListener {
            if (it.currentUser == null) {
                Log.d(TAG, "signOut::success")
                navController.navigate(Screen.SignInScreen.route) {
                    launchSingleTop = true
                    popUpTo(Screen.HomeScreen.route) {
                        inclusive = true
                    }
                }
            } else {
                Log.d(TAG, "signOut::failure")
            }
        }
        FirebaseAuth.getInstance().addAuthStateListener(authStateListener)
    }

}