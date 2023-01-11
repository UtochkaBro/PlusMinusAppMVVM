package com.example.plusminusappmvvm.screens

import android.app.Application
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.plusminusappmvvm.MainViewModel
import com.example.plusminusappmvvm.MainViewModelFactory
import com.example.plusminusappmvvm.model.Note
import com.example.plusminusappmvvm.navigation.NavRoute
import com.example.plusminusappmvvm.ui.theme.PlusMinusAppMVVMTheme

@Composable
fun MainScreen(navController: NavHostController) {
    val context = LocalContext.current
    val mViewModel: MainViewModel =
        viewModel(factory = MainViewModelFactory(context.applicationContext as Application))

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    navController.navigate(NavRoute.Add.route)
                }) {
                Icon(imageVector = Icons.Filled.Add, contentDescription = "Icons add", tint = Color.White)
            }
        }
    ) {
//        Column() {
//            NoteItem(title = "Title1", subTitle = "SubTitle is just fuckin text for title 1", navController = navController)
//            NoteItem(title = "Title2", subTitle = "SubTitle is just fuckin text for title 2", navController = navController)
//            NoteItem(title = "Title3", subTitle = "SubTitle is just fuckin text for title 3", navController = navController)
//            NoteItem(title = "Title4", subTitle = "SubTitle is just fuckin text for title 4", navController = navController)
//            NoteItem(title = "Title5", subTitle = "SubTitle is just fuckin text for title 5", navController = navController)
//            NoteItem(title = "Title6", subTitle = "SubTitle is just fuckin text for title 6", navController = navController)
//            NoteItem(title = "Title7", subTitle = "SubTitle is just fuckin text for title 7", navController = navController)
//
//        }
//        LazyColumn(){
//            items(notes) { note ->
//                NoteItem(note = note, navController = navController)
//            }
//        }
        }
}

@Composable
fun NoteItem(note: Note, navController: NavHostController) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp, horizontal = 24.dp)
            .clickable {
                navController.navigate(NavRoute.Note.route)
            },
        elevation = 6.dp
    ) {
        Column(modifier = Modifier
            .padding(vertical = 8.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = note.title,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )
            Text(text = note.subTitle)
        }

    }
}

@Preview(showBackground = true)
@Composable
fun prevMainScreen(){
    PlusMinusAppMVVMTheme() {
        MainScreen(navController = rememberNavController())
    }
}