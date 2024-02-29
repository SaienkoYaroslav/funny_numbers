package com.example.funnynumbers.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

@Composable
fun DetailScreen(
    numberViewModel: NumberViewModel,
    navController: NavHostController
) {
    val detailNumber = numberViewModel.detailNumber
    var isEnable by remember {
        mutableStateOf(true)
    }
    Box(
        modifier = Modifier
            .padding(10.dp)
    ) {
        IconButton(
            enabled = isEnable,
            onClick = {
                isEnable = false
                navController.popBackStack()
            }
        ) {
            Icon(Icons.Default.ArrowBack, contentDescription = "Back")
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = detailNumber?.number?.toString() ?: "Oops...",
            fontSize = 34.sp
        )

        Spacer(modifier = Modifier.height(30.dp))

        Text(
            modifier = Modifier.padding(horizontal = 10.dp),
            fontSize = 20.sp,
            text = detailNumber?.text ?: "Something went wrong",
        )
    }

}