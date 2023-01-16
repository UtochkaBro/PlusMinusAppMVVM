package com.example.plusminusappmvvm.screens

import android.app.Application
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.plusminusappmvvm.MainViewModel
import com.example.plusminusappmvvm.MainViewModelFactory
import com.example.plusminusappmvvm.navigation.NavRoute
import com.example.plusminusappmvvm.ui.theme.PlusMinusAppMVVMTheme
import com.example.plusminusappmvvm.utils.TYPE_FIREBASE
import com.example.plusminusappmvvm.utils.TYPE_ROOM

@Composable
fun StartScreen(navController: NavHostController, viewModel: MainViewModel) {
    val context = LocalContext.current
    val mViewModel: MainViewModel =
        viewModel(factory = MainViewModelFactory(context.applicationContext as Application))
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
                        mViewModel.initDatabase(TYPE_ROOM) {
                            navController.navigate(route = NavRoute.Main.route)
                        }

                    },
                    modifier = Modifier
                        .width(200.dp)
                        .padding(vertical = 8.dp)
                ) {
                    Text(text = "Room database")
                }

                Button(
                    onClick = {
                        mViewModel.initDatabase(TYPE_FIREBASE) {
                            navController.navigate(route = NavRoute.Main.route)
                        }

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
        val context = LocalContext.current
        val mViewModel: MainViewModel =
            viewModel(factory = MainViewModelFactory(context.applicationContext as Application))

        StartScreen(navController = rememberNavController(), viewModel = mViewModel)
    }
}