package com.example.mainappcenter

import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.mainappcenter.appScreens.*

@ExperimentalMaterialApi
@ExperimentalComposeUiApi
@Composable
fun BottomNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = BottomBarComponents.Home.route
    ) {
        composable(route = BottomBarComponents.Home.route) {
            HomeScreensetting(navController)
        }
        composable(route = BottomBarComponents.YourQueue.route) {
            SelectionScreensetting()
        }
        composable(route = BottomBarComponents.Records.route) {
            RecordScreenSetting()
        }
        /**
        composable(route = ButtonTransitionScreen.Registration.rounte){
            LoginSetting()
        }**/
        composable(route = ButtonTransitionScreen.Setting.rounte){
            setupsettinscreen(navController)
        }
        /**
        composable(route = ButtonTransitionScreen.SingIn.rounte){
            SetSignin()
        }**/
    }
}