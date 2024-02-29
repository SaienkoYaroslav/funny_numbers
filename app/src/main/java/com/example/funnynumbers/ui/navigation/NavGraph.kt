package com.example.funnynumbers.ui.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.funnynumbers.ui.DetailScreen
import com.example.funnynumbers.ui.MainScreen
import com.example.funnynumbers.ui.NumberViewModel

@Composable
fun NavGraph(
    navHostController: NavHostController,
    viewModel: NumberViewModel = hiltViewModel()
) {
    NavHost(
        navController = navHostController,
        startDestination = NavScreen.MainScreen.route
    ) {

        composable(
            route = NavScreen.MainScreen.route
        ) {
            MainScreen(numberViewModel = viewModel, navController = navHostController)
        }

        composable(
            route = NavScreen.DetailScreen.route
        ) {
            DetailScreen(numberViewModel = viewModel, navController = navHostController)
        }

    }
}