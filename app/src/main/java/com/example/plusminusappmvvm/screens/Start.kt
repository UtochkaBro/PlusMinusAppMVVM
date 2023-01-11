package com.example.plusminusappmvvm.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.plusminusappmvvm.navigation.NavRoute
import com.example.plusminusappmvvm.ui.theme.PlusMinusAppMVVMTheme

@Composable
fun StartScreen(navController: NavHostController) {
        Scaffold(
            modifier = Modifier
                .fillMaxSize()
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.LightGray),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(text = "What will we use?")
                Button(
                    onClick = {
                              navController.navigate(route = NavRoute.Main.route)
                    },
                    modifier = Modifier
                        .width(200.dp)
                        .padding(vertical = 8.dp)
                ) {
                    Text(text = "Room database")
                }

                Button(
                    onClick = {
                        navController.navigate(route = NavRoute.Main.route)
                    },
                    modifier = Modifier
                        .width(200.dp)
                        .padding(vertical = 8.dp)
                ) {
                    Text(text = "Firebase database")
                }
            }
        }
}

@Preview(showBackground = true)
@Composable
fun prevStartScreen(){
    PlusMinusAppMVVMTheme() {
        StartScreen(navController = rememberNavController())
    }
}