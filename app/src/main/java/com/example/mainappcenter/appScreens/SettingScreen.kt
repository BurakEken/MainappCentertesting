package com.example.mainappcenter.appScreens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import com.example.mainappcenter.BottomBarComponents
import com.example.mainappcenter.ui.theme.bordergreeny

//Need to add the app Navigation Component for the Changing of the Screen when the Join Button Which is in the HomeScreen is click
//Need to also make sure the Navigation component works when the back Key is pressed and also when the OK Button is pressed in the Compose ()

@ExperimentalComposeUiApi
@Composable
fun setupsettinscreen(navController: NavHostController?){
    Surface(color = MaterialTheme.colors.background, modifier = Modifier.fillMaxHeight()) {
        Settingscreen(navController)
    }
}


@ExperimentalComposeUiApi
@Composable
fun Settingscreen(navController: NavHostController?){
    val checkedState = remember { mutableStateOf(true) }
    val checkedState2 = remember { mutableStateOf(true) }
    Column{
        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Surface(
                modifier = Modifier.size(90.dp),
                shape = CircleShape,
                color = MaterialTheme.colors.onSurface.copy(alpha = 0.2f)
            ) {
                // Image goes here
            }
        }

        Text(text = "Permission:", style = MaterialTheme.typography.h4.copy(
            fontWeight = FontWeight.ExtraBold
        ))
        Divider(color= Color.Black,thickness=1.dp)
        Row(modifier = Modifier.padding(start = 7.dp,top = 7.dp, bottom = 5.dp)){

            Text(text = "Location", fontFamily = FontFamily.SansSerif,fontWeight = FontWeight.Normal,fontSize=25.sp,modifier = Modifier.align(
                Alignment.CenterVertically))
            Switch(
                checked = checkedState.value,
                onCheckedChange = { checkedState.value = it },
                modifier = Modifier.align(Alignment.CenterVertically)

            )
        }

        Row(modifier = Modifier.padding(start = 7.dp,top = 7.dp)){
            Text(text = "Notification", fontFamily = FontFamily.SansSerif,fontWeight = FontWeight.Normal,fontSize=25.sp,modifier = Modifier.align(
                Alignment.CenterVertically))
            Switch(
                checked = checkedState2.value,
                onCheckedChange = { checkedState2.value = it },
                modifier = Modifier
                    .padding(top = 9.dp)
                    .align(Alignment.CenterVertically)
            )
        }
        Divider(color= Color.Black,thickness=1.dp)

        Text(text = "CHANGE DETAILS:", modifier = Modifier.padding(top=7.dp),style = MaterialTheme.typography.h4.copy(
            fontWeight = FontWeight.ExtraBold
        ))

        Divider(color= Color.Black,thickness=1.dp)
        Spacer(modifier = Modifier.padding(top=29.dp))
        StyledTextField(navController)



    }
}
@ExperimentalComposeUiApi
@Composable
fun StyledTextField(navController: NavHostController?) {
    var Nametext by remember { mutableStateOf("") }
    var Passwordtext by remember { mutableStateOf("") }
    var Phonenumbertext by remember { mutableStateOf("") }
    val keyboardController =  LocalSoftwareKeyboardController.current
    val (focusPassword,focusPhonenumber) = remember { FocusRequester.createRefs()}
    Column(modifier = Modifier.fillMaxWidth()) {


        OutlinedTextField(
            value = Nametext,
            modifier = Modifier
                .padding(top = 7.dp)
                .align(Alignment.CenterHorizontally),
            onValueChange = { Nametext = it },
            label = { Text("NAME:", color = bordergreeny,fontSize=20.sp) },
            placeholder={ Text("Your Name") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text,imeAction = ImeAction.Next),
            keyboardActions = KeyboardActions(onNext = {focusPassword.requestFocus()}),
            colors = TextFieldDefaults.outlinedTextFieldColors(cursorColor= bordergreeny,focusedBorderColor= bordergreeny)
        )

        OutlinedTextField(
            value = Passwordtext,
            modifier = Modifier
                .padding(top = 7.dp)
                .align(Alignment.CenterHorizontally)
                .focusRequester(focusPassword),
            onValueChange = { Passwordtext = it },
            label = { Text("PASSWORD:", color = bordergreeny,fontSize=20.sp) },
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password, imeAction = ImeAction.Next),
            keyboardActions = KeyboardActions(onNext = {focusPhonenumber.requestFocus()}),
            colors = TextFieldDefaults.outlinedTextFieldColors(cursorColor= bordergreeny,focusedBorderColor= bordergreeny)
        )

        OutlinedTextField(
            value = Phonenumbertext,
            modifier = Modifier
                .padding(top = 7.dp)
                .align(Alignment.CenterHorizontally)
                .focusRequester(focusPhonenumber),
            onValueChange = { Phonenumbertext = it },
            label = { Text("PHONE NUMBER:", color = bordergreeny,fontSize=20.sp) },
            placeholder={ Text("+90 533...") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone, imeAction = ImeAction.Done),
            keyboardActions = KeyboardActions (onDone = {keyboardController?.hide()}),
            colors = TextFieldDefaults.outlinedTextFieldColors(cursorColor= bordergreeny,focusedBorderColor= bordergreeny)
        )
        Spacer(modifier = Modifier.padding(top=15.dp))
        ConstraintLayout(modifier = Modifier.fillMaxWidth()) {
            val (Okbutton) = createRefs()
            Button(onClick = { navController?.navigate(BottomBarComponents.Home.route ){ popUpTo(navController.graph.findStartDestination().id)
                launchSingleTop = true} },shape= RoundedCornerShape(16.dp),modifier = Modifier.constrainAs(Okbutton) {
                absoluteRight.linkTo(parent.end, margin = 16.dp)
            },colors = ButtonDefaults.textButtonColors(
                backgroundColor = bordergreeny)) {
                Text("OK", color = Color.Black)
            }
        }


    }



}

@ExperimentalComposeUiApi
@Preview(showBackground = true)
@Composable
fun SettingPreview() {

    setupsettinscreen(null)

}