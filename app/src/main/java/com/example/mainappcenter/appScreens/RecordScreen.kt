package com.example.mainappcenter.appScreens

import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun RecordScreenSetting(){
    Surface(color = MaterialTheme.colors.primary, modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight()) {
        Column() {
            RecordUIBuild("Name: ", "Cem")
            RecordUIBuild("AGE: ", "25")
            RecordUIBuild("Status: ", "Vaccinated")
            RecordUIBuild("Vaccine Name:  ", "Astra-Zz")
            RecordUIBuild("Vaccine Type?: ", "T27-005CM")
        }
    }
}
@Composable
fun RecordUIBuild(subject: String,topic:String) {

    Row{
        Text(text = "$subject:",style = MaterialTheme.typography.body2, fontSize = 20.sp, modifier = Modifier.padding(top = 5.dp, start = 3.dp))
        Text(text = "$topic",style = MaterialTheme.typography.body2, fontSize = 20.sp, modifier = Modifier.padding(top = 5.dp, start = 3.dp))
    }
    Divider(color = Color.Black, modifier = Modifier
        .fillMaxWidth()
        .width(1.dp))





}

@Preview(showBackground = true)
@Composable
fun RecordScreenPreview() {
        RecordScreenSetting()
}