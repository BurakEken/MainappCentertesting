package com.example.mainappcenter.appScreens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.mainappcenter.ui.theme.bordergreeny
import com.example.mainappcenter.ui.theme.cardcolor
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.navigation.NavHostController
import com.example.mainappcenter.BottomBarComponents
import com.example.mainappcenter.ButtonTransitionScreen


@ExperimentalMaterialApi
@ExperimentalComposeUiApi
@Composable
fun HomeScreensetting(navController: NavHostController?){
        HomeUIBody(navController=navController)

}


@ExperimentalMaterialApi
@Composable
fun HomeUIBody(names: List<String> = List(7) { "$it" },navController: NavHostController?){
    Column(modifier = Modifier.fillMaxWidth()) {
        Card(backgroundColor = cardcolor,
            elevation = 7.dp, modifier = Modifier
                .fillMaxWidth()
                .padding(2.dp), shape = RoundedCornerShape(8.dp),onClick = {navController?.navigate(
                ButtonTransitionScreen.Setting.rounte ) }
        ) {
            Row {
                Surface(
                    modifier = Modifier.size(50.dp),
                    shape = CircleShape,
                    color = MaterialTheme.colors.onSurface.copy(alpha = 0.2f)
                ) {
                    // Image goes here

                }
                Column {
                    Text("Cem", fontWeight = FontWeight.Bold)
                    CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.medium) {
                        Text("Vaccinated", style = MaterialTheme.typography.body2)
                    }
                }
            }
        }
        LazyColumn(modifier = Modifier.padding(vertical = 4.dp)) {
            items(items = names) { name ->
                listofVaccineCenters("W.H.O","Close",1.3,0,navController=navController)
                listofVaccineCenters("M.E.T.U Clinic","Open",1.7,5,"7 mins",navController=navController)
                listofVaccineCenters("Guzelyurt Clinic","Open",1.6,10,"15 mins",navController=navController)
            }

        }


    }
}
@Composable
fun listofVaccineCenters(centerName:String,centerStatus:String,centerDistance:Double,numberInQueue:Int,avgQueuTime:String="",navController: NavHostController?){
    val setbuttonStaus by rememberSaveable { mutableStateOf(centerStatus) }

    Row (modifier = Modifier
        .fillMaxWidth()
        .padding(top = 4.dp).clickable { navController?.navigate(BottomBarComponents.YourQueue.route)}){
        Surface(
            modifier = Modifier.size(50.dp),
            shape = CircleShape,
            color = MaterialTheme.colors.onSurface.copy(alpha = 0.2f)
        ) {
            // Image goes here
        }
        Column(modifier= Modifier.padding(start=5.dp)) {
            Row(modifier = Modifier.height(IntrinsicSize.Min)) {
                Text(centerName,fontWeight = FontWeight.Bold, modifier = Modifier.padding(end = 8.dp))

                Text(text = centerStatus,modifier = Modifier.padding(end = 2.dp))
                Divider(color = Color.Black, modifier = Modifier
                    .fillMaxHeight()
                    .width(1.dp))
                Text(text = "$centerDistance km",modifier = Modifier.padding(start = 2.dp))

            }

            Card(backgroundColor = cardcolor, modifier = Modifier.size(width = 60.dp, height = 30.dp)) {
                Box(Modifier.wrapContentSize(Alignment.Center)) {
                    Text(text = "$numberInQueue", fontSize = 20.sp, modifier = Modifier)
                }

            }

        }
        ConstraintLayout(modifier = Modifier.fillMaxWidth()) {
            val (Textt,joinButton) = createRefs()
            Text(avgQueuTime, Modifier.constrainAs(Textt) {
                absoluteRight.linkTo(parent.end, margin = 16.dp)
                // Centers Text horizontally in the ConstraintLayout
            })
            if(setbuttonStaus.equals("Open")){
                Button(onClick = {navController?.navigate(BottomBarComponents.YourQueue.route ) },shape= RoundedCornerShape(16.dp),modifier = Modifier.constrainAs(joinButton) {
                    absoluteRight.linkTo(parent.end, margin = 16.dp)
                    top.linkTo(parent.bottom, margin = 10.dp)
                },colors = ButtonDefaults.textButtonColors(
                    backgroundColor = bordergreeny)) {
                    Text("JOIN", color = Color.Black)
                }
            }


        }

    }
    Spacer(modifier = Modifier.padding(top=20.dp))
    Divider(color = Color.Black, modifier = Modifier
        .fillMaxWidth()
        .width(1.dp))




}


@ExperimentalMaterialApi
@ExperimentalComposeUiApi
@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    HomeScreensetting(null)

}

