package com.example.mainappcenter.appScreens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mainappcenter.ui.theme.bordergreeny
import com.example.mainappcenter.ui.theme.cardcolor
import com.example.mainappcenter.ui.theme.largecardcolor

@Composable
fun SelectionScreensetting(){
    SelectionScreen("M.E.T.U Clinic","OPEN","Astra-zz","11-23(2020)","15")
}
@Composable
fun SelectionScreen(vaccineCenterName:String,vaccineCenterStatus:String,vaccineNames: String,vaccineCenterOperationDates:String,vaccineQueueNumber:String) {
    Column() {
        Card(backgroundColor = cardcolor,
            elevation = 7.dp, modifier = Modifier
                .fillMaxWidth()
                .padding(2.dp), shape = RoundedCornerShape(8.dp)
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
                    Text(vaccineCenterName, fontWeight = FontWeight.Bold)
                    CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.medium) {
                        Text(vaccineCenterStatus, style = MaterialTheme.typography.body2)
                    }
                }
            }
        }



        Card(backgroundColor = largecardcolor,modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .padding(top = 170.dp),shape = RoundedCornerShape(topStart = 15.dp, topEnd = 15.dp)
        ) {
            Column {
                Row() {
                    Text("VACCINE TYPE:", style = MaterialTheme.typography.body2, fontSize = 25.sp, modifier = Modifier.padding(top = 5.dp, start = 3.dp))
                    Text (vaccineNames,style = MaterialTheme.typography.body2, fontSize = 25.sp, modifier = Modifier.padding(top = 5.dp))
                }
                Divider(color = Color.Black, modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 10.dp)
                    .width(25.dp))
                Row() {
                    Text("OPERATION DATE : ", style = MaterialTheme.typography.body2, fontSize = 25.sp, modifier = Modifier.padding(top = 5.dp, start = 3.dp))
                    Text (vaccineCenterOperationDates,style = MaterialTheme.typography.body2, fontSize = 25.sp, modifier = Modifier.padding(top = 5.dp))
                }
                Divider(color = Color.Black, modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 10.dp)
                    .width(25.dp))
                Row{
                    Card(backgroundColor = cardcolor,
                        elevation = 9.dp, modifier = Modifier
                            .fillMaxWidth()
                            .size(170.dp)
                            .height(80.dp)
                            .padding(10.dp), shape = RoundedCornerShape(8.dp)
                    ) {

                        Text("Queueing Number :$vaccineQueueNumber ", style = MaterialTheme.typography.body2, fontSize = 20.sp, modifier = Modifier.padding(top = 5.dp, start = 3.dp))
                        Box(Modifier.wrapContentSize(Alignment.TopEnd)) {
                            Button(
                                onClick = { /* ... */ },
                                // Uses ButtonDefaults.ContentPadding by default
                                contentPadding = PaddingValues(
                                    start = 20.dp,
                                    top = 12.dp,
                                    end = 20.dp,
                                    bottom = 12.dp
                                ), modifier = Modifier.padding(end = 5.dp,top=5.dp),shape= RoundedCornerShape(16.dp), colors = ButtonDefaults.textButtonColors(
                                    backgroundColor = bordergreeny)) {
                                Text("JOIN", color = Color.Black)
                            }
                        }


                    }
                }
            }

        }
    }

}

@Preview(showBackground = true)
@Composable
fun SelectionScreenPreview() {

        SelectionScreen("M.E.T.U Clinic","OPEN","Astra-zz","11-23(2020)","15")

}