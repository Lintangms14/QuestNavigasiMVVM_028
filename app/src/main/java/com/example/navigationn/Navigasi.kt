package com.example.navigationn

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.navigationn.model.ListGender
import com.example.navigationn.ui.view.FormMahasiswaView
import com.example.navigationn.ui.viewmodel.Mahasiswaviewmodel

enum class Halaman{
    Form,
    Data
}

@Composable
fun Navigasi(
    modifier: Modifier = Modifier,
    viewModel: Mahasiswaviewmodel = viewModel(),
    navHost: NavHostController = rememberNavController()
){
    Scaffold { isipadding ->
        val uiState by viewModel.dataModel.collectAsState()
        NavHost(
            modifier = modifier.padding(isipadding),
            navController = navHost, startDestination = Halaman.Form.name
        ) {
            composable(route = Halaman.Form.name) {
                val konteks = LocalContext.current
                FormMahasiswaView(
                    //Di bawah ini merupakan dari parameter halaman FormulirView
                    listGender = ListGender.ListGender.map { id ->
                        konteks.getString(id)
                    },
                    onSubmitClick = {
                        viewModel.saveDataMhs(it)
                        navHost.navigate(Halaman.Data.name)
                    }
                )
            }
        }
    }
}