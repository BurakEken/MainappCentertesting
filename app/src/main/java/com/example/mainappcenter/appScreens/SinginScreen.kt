package com.example.mainappcenter.appScreens

import androidx.compose.foundation.layout.*
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
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mainappcenter.ui.theme.bordergreeny

@ExperimentalComposeUiApi
@Composable
fun SetSignin(onContinueClicked: () -> Unit){

    var Passwordtext by remember { mutableStateOf("") }
    var Phonenumbertext by remember { mutableStateOf("") }
    val keyboardController =  LocalSoftwareKeyboardController.current
    val (focusPassword,focusPhonenumber) = remember { FocusRequester.createRefs()}

    Column() {
        Text("PHONE NUMBER:", color = bordergreeny,fontSize=20.sp)
        OutlinedTextField(
            value = Phonenumbertext,
            modifier = Modifier
                .padding(top = 7.dp)
                .align(Alignment.CenterHorizontally)
                .focusRequester(focusPhonenumber),
            onValueChange = { Phonenumbertext = it },
            label = { Text("PHONE NUMBER:", color = bordergreeny,fontSize=20.sp) },
            placeholder={ Text("+90 533...") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone, imeAction = ImeAction.Next),
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
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password, imeAction = ImeAction.Done),
            keyboardActions = KeyboardActions (onDone = {keyboardController?.hide()}),
            colors = TextFieldDefaults.outlinedTextFieldColors(cursorColor= bordergreeny,focusedBorderColor= bordergreeny)
        )

        Box(modifier = Modifier.fillMaxWidth()) {
            Button(
                onClick =  onContinueClicked ,
                // Uses ButtonDefaults.ContentPadding by default
                contentPadding = PaddingValues(
                    start = 20.dp,
                    top = 12.dp,
                    end = 20.dp,
                    bottom = 12.dp
                ), modifier = Modifier.align(Alignment.Center).padding(top=4.dp),shape= RoundedCornerShape(16.dp), colors = ButtonDefaults.textButtonColors(
                    backgroundColor = bordergreeny
                )) {
                Text("SIGN IN", color = Color.Black)
            }
        }

    }
}
@ExperimentalComposeUiApi
@Preview(showBackground = true)
@Composable
fun PermissionPrevieww() {
    SetSignin(onContinueClicked = {  false })
}