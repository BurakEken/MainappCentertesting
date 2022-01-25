package com.example.mainappcenter

sealed class ButtonTransitionScreen(val rounte:String) {
    object Registration:ButtonTransitionScreen("registration")
    object Setting:ButtonTransitionScreen("Setting")
    object SingIn:ButtonTransitionScreen("signIn")
}