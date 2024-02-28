package com.example.funnynumbers.ui

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.funnynumbers.data.db.NumberEntity
import com.example.funnynumbers.data.mapper.Mapper
import com.example.funnynumbers.domain.model.MyNumber
import com.example.funnynumbers.ui.navigation.NavScreen
import com.example.funnynumbers.ui.theme.Purple40
import kotlinx.coroutines.launch

@Composable
fun MainScreen(
    numberViewModel: NumberViewModel,
    navController: NavHostController
) {
    val context = LocalContext.current
    var text by remember {
        mutableStateOf("")
    }
    val scope = rememberCoroutineScope()
    val mapper = Mapper()
    val mutableListNumbers: MutableList<MyNumber> = remember { mutableStateListOf() }
    val listNumbers: List<MyNumber> by rememberUpdatedState(mutableListNumbers)
    val listss = mutableListNumbers.get(0)
    val listBD = mapper.mapMyNumberToNumberEntity(listss)
    val numbersListFromDb = numberViewModel.numbersList.collectAsState(initial = emptyList())

    Column(
        Modifier
            .fillMaxSize()
            .padding(top = 50.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {

        val maxChar = 9

        TextField(
            value = text,
            onValueChange = {
                if (it.length <= maxChar) text = it
            },
            maxLines = 1,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number,
            ),
            label = {
                Text("Enter an integer")
            },
            supportingText = {
                Text(
                    text = "${text.length} / $maxChar",
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center,
                )
            },
        )

        Button(
            onClick = {
                scope.launch {
                    if (text.trim().toIntOrNull() != null) {
                        val number =
                            numberViewModel.getNumberById(text.trim().toInt())
                        mutableListNumbers.add(number)
                    } else {
                        Toast.makeText(
                            context,
                            "Enter an integer without spaces",
                            Toast.LENGTH_SHORT
                        ).show()
                    }

                }
            }
        ) {
            (
                    Text(
                        text = "Get fact",
                        fontSize = 20.sp
                    )
                    )
        }
        Button(
            onClick = {
                scope.launch {
                    val number =
                        numberViewModel.getRandomNumber()
                    mutableListNumbers.add(number)
                }
            }
        ) {
            (
                    Text(
                        text = "Get fact about random number",
                        fontSize = 20.sp
                    )
                    )
        }

        Spacer(modifier = Modifier.height(10.dp))
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(1.dp)
                .background(Purple40)
        )
        Spacer(modifier = Modifier.height(10.dp))

        LazyColumn(
            modifier = Modifier
                .padding(bottom = 10.dp, start = 10.dp, end = 10.dp)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            items(items = listNumbers.reversed()) { item ->
                ListItem(
                    number = item,
                    navController = navController
                )
            }
        }

    }
}

@Composable
fun ListItem(
    number: NumberEntity,
    navController: NavHostController
) {

    Row(
        Modifier
            .fillMaxSize()
            .clickable {
                navController.navigate(NavScreen.DetailScreen.route)
            },
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            modifier = Modifier
                .padding(bottom = 20.dp),
            text = "${number.number} - ${number.text}",
            fontSize = 20.sp,
            maxLines = 1
        )
    }

}