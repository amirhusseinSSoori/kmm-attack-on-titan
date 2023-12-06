package com.AmirHusseinSoori.attackOnTitan


import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.paging.PagingData
import app.cash.paging.compose.collectAsLazyPagingItems

import com.AmirHusseinSoori.attackOnTitan.data.Result


import com.AmirHusseinSoori.attackOnTitan.data.di.ViewModelModule
import com.AmirHusseinSoori.attackOnTitan.ui.ImageScreen.AtackOnTitanViewModel
import com.AmirHusseinSoori.attackOnTitan.ui.util.shimmerBackground
import com.seiko.imageloader.rememberImagePainter
import moe.tlaster.precompose.PreComposeApp


@Composable
internal fun App(imageViewModel: AtackOnTitanViewModel = ViewModelModule.injectAttackOnTitanViewModel()) {
    PreComposeApp {
        val characterItem= imageViewModel.getAllCharacter().collectAsLazyPagingItems()

        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(all = 12.dp),
        ) {
            items(characterItem.itemSnapshotList) {
                Column {
                    Text(it?.name ?: "")
                    Image(
                        painter = rememberImagePainter(
                            it?.img ?: ""
                        ),
                        contentDescription = "content",
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(300.dp).shimmerBackground(
                                RoundedCornerShape(5.dp)
                            ),
                        contentScale = ContentScale.Crop,
                    )
                }

            }


        }


    }
}



