package com.example.mainappcenter

import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.navigation.NavHostController
import com.example.mainappcenter.appScreens.HomeUIBody
import com.example.mainappcenter.appScreens.LoginSetting

@ExperimentalMaterialApi
@ExperimentalComposeUiApi
@Composable
fun HouseScreens() {
    var shouldShowOnboarding by rememberSaveable { mutableStateOf(true) }
    if(shouldShowOnboarding ){
        LoginSetting(onContinueClicked = { shouldShowOnboarding = false })
    }
    else
      MainControlCenter()


}