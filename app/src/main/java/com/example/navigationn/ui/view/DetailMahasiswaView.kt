package com.example.navigationn.ui.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.navigationn.model.Mahasiswa

@Composable
fun DetailMahasiswaView(
    dataMhs: Mahasiswa,
    modifier: Modifier,
    onClickButton: () -> Boolean
){
    val listDataMhs = listOf(
        Pair("Nama", dataMhs.nama),
        Pair("Gender", dataMhs.gender),
        Pair("Alamat", dataMhs.alamat)
    )
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        listDataMhs.forEach { data ->
            DetailMhs(
                judul = data.first,
                isi = data.second
            )
        }
    }
}

@Composable
fun DetailMhs(
    judul:String, isi: String
){}