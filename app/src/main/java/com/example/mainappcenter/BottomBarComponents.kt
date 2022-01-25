package com.example.mainappcenter

import androidx.compose.material.icons.Icons
import androidx.compose.material.Icon
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomBarComponents ( val route: String,
                                   val title: String,
                                   val icon: ImageVector){

    val MyAppIcons = Icons.Rounded


        object Home : BottomBarComponents(
            route = "home",
            title = "Home",
            icon = Icons.Default.Home
        )

        object YourQueue : BottomBarComponents(
            route = "your queue",
            title = "Your Queue",
            icon = Icons.Default.Person
        )

        object Records : BottomBarComponents(
            route = "records",
            title = "Records",
            icon = Icons.Default.Notifications
        )



}