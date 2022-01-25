package com.example.mainappcenter.appScreens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
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
 fun LoginSetting(onContinueClicked: () -> Unit){
    var goToSignin by rememberSaveable { mutableStateOf(true) }
    if(goToSignin ){
       // SettingRegistrationscreen(onContinueClicked)
        SettingRegistrationscreen(onContinueRegistration = { goToSignin = false })
    }
    else
        SetSignin(onContinueClicked)

}



@ExperimentalComposeUiApi
@Composable
fun  SettingRegistrationscreen(onContinueRegistration: () -> Unit){
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




        Spacer(modifier = Modifier.padding(top=29.dp))
        StyledTextFieldLogin(onContinueRegistration)



    }
}
@ExperimentalComposeUiApi
@Composable
fun StyledTextFieldLogin(onContinueRegistration: () -> Unit) {
    var Nametext by remember { mutableStateOf("") }
    var Agetext by remember { mutableStateOf("") }
    var Ssntext by remember { mutableStateOf("") }
    var Passwordtext by remember { mutableStateOf("") }
    var Phonenumbertext by remember { mutableStateOf("") }
    var Emailtext by remember { mutableStateOf("") }
    val keyboardController =  LocalSoftwareKeyboardController.current
    val (focusAge,focusPassword,focusPhonenumber,focusSsn,focusEmail) = remember { FocusRequester.createRefs()}
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
            keyboardActions = KeyboardActions(onNext = {focusAge.requestFocus()}),
            colors = TextFieldDefaults.outlinedTextFieldColors(cursorColor= bordergreeny,focusedBorderColor= bordergreeny)
        )

        OutlinedTextField(
            value = Agetext,
            modifier = Modifier
                .padding(top = 7.dp)
                .align(Alignment.CenterHorizontally)
                .focusRequester(focusAge),
            onValueChange = { Agetext = it },
            label = { Text("AGE:", color = bordergreeny,fontSize=20.sp) },
            placeholder={ Text("19") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number, imeAction = ImeAction.Next),
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
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone, imeAction = ImeAction.Next),
            keyboardActions = KeyboardActions(onNext = {focusSsn.requestFocus()}),
            colors = TextFieldDefaults.outlinedTextFieldColors(cursorColor= bordergreeny,focusedBorderColor= bordergreeny)
        )

        OutlinedTextField(
            value = Ssntext,
            modifier = Modifier
                .padding(top = 7.dp)
                .align(Alignment.CenterHorizontally)
                .focusRequester(focusSsn),
            onValueChange = { Ssntext = it },
            label = { Text("SSN:", color = bordergreeny,fontSize=20.sp) },
            placeholder={ Text("23-45-667") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text, imeAction = ImeAction.Next),
            keyboardActions = KeyboardActions(onNext = {focusEmail.requestFocus()}),
            colors = TextFieldDefaults.outlinedTextFieldColors(cursorColor= bordergreeny,focusedBorderColor= bordergreeny)
        )


        OutlinedTextField(
            value = Emailtext,
            modifier = Modifier
                .padding(top = 7.dp)
                .align(Alignment.CenterHorizontally)
                .focusRequester(focusEmail),
            onValueChange = { Emailtext = it },
            label = { Text("EMAIL:", color = bordergreeny,fontSize=20.sp) },
            placeholder={ Text("Cem@gmail.com") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email, imeAction = ImeAction.Next),
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


        Spacer(modifier = Modifier.padding(top=15.dp))
        Row(modifier = Modifier.fillMaxWidth()){
            Box(Modifier.fillMaxWidth()) {
                Button(
                    onClick =onContinueRegistration


                        // mapper.writeValueAsString()
                    ,
                    // Uses ButtonDefaults.ContentPadding by default
                    contentPadding = PaddingValues(
                        start = 20.dp,
                        top = 12.dp,
                        end = 20.dp,
                        bottom = 12.dp
                    ), modifier = Modifier.align(Alignment.BottomStart).padding(top=5.dp, start = 5.dp),shape= RoundedCornerShape(16.dp), colors = ButtonDefaults.textButtonColors(
                        backgroundColor = bordergreeny)) {
                    Text("REGISTER", color = Color.Black)
                }
                Button(
                    onClick = onContinueRegistration ,
                    // Uses ButtonDefaults.ContentPadding by default
                    contentPadding = PaddingValues(
                        start = 20.dp,
                        top = 12.dp,
                        end = 20.dp,
                        bottom = 12.dp
                    ), modifier = Modifier.align(Alignment.BottomEnd).padding(top=5.dp,end = 5.dp),shape= RoundedCornerShape(16.dp), colors = ButtonDefaults.textButtonColors(
                        backgroundColor = bordergreeny)) {
                    Text("SING IN", color = Color.Black)
                }

            }


        }

    }



}

@ExperimentalComposeUiApi
@Preview(showBackground = true)
@Composable
fun RegistrationPreview() {

    LoginSetting(onContinueClicked = { false })

}