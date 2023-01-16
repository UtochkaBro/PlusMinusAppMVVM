package com.example.plusminusappmvvm.screens

import android.app.Application
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.plusminusappmvvm.MainViewModel
import com.example.plusminusappmvvm.MainViewModelFactory
import com.example.plusminusappmvvm.ui.theme.PlusMinusAppMVVMTheme

@Composable
fun NoteScreen(navController: NavHostController, viewModel: MainViewModel) {
    Scaffold(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Column(
            modifier =Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Card(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(32.dp)
            ) {
                Column(
                    modifier = Modifier.padding(vertical = 8.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "Title",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(top = 32.dp)
                    )
                    Text(text = "SubTitle")
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun prevNoteScreen() {
    PlusMinusAppMVVMTheme() {
        val context = LocalContext.current
        val mViewModel: MainViewModel =
            viewModel(factory = MainViewModelFactory(context.applicationContext as Application))

        NoteScreen(navController = rememberNavController(), viewModel = mViewModel)
    }
}