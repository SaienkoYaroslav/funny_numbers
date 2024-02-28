package com.example.funnynumbers.ui

import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun DetailScreen(){
    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Number",
            fontSize = 34.sp
        )

        Spacer(modifier = Modifier.height(30.dp))

        Text(
            modifier = Modifier.padding(horizontal = 10.dp),
            fontSize = 20.sp,
            text = "Long long long  long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long description",
            )
    }

}