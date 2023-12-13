package com.AmirHusseinSoori.attackOnTitan



import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items

import androidx.compose.material.Icon
import androidx.compose.material.Scaffold

import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import app.cash.paging.compose.collectAsLazyPagingItems


import com.AmirHusseinSoori.attackOnTitan.data.di.ViewModelModule

import com.AmirHusseinSoori.attackOnTitan.ui.AtackOnTitanViewModel
import com.AmirHusseinSoori.attackOnTitan.ui.character.CharacterItem

import moe.tlaster.precompose.PreComposeApp


@Composable
internal fun App(imageViewModel: AtackOnTitanViewModel = ViewModelModule.injectAttackOnTitanViewModel()) {
    PreComposeApp {
        val characterItem = imageViewModel.getAllCharacter().collectAsLazyPagingItems()

        Scaffold(
            topBar = {
                TopAppBar(
                    title = {
                        Text("Attack onTitan")
                    },navigationIcon = {
                        Box(
                            modifier = Modifier.fillMaxWidth().padding(end = 16.dp)
                        ) {
                            IconButton(
                                onClick = { /* Handle click here */ }
                            ) {
                                Icon(
                                    imageVector = Icons.Default.MoreVert,
                                    contentDescription = "Navigation icon"
                                )
                            }
                        }

                    }
                )
            },
        ) { innerPadding ->

            Column {

                LazyColumn(
                    modifier = Modifier.fillMaxSize(),
                    contentPadding = PaddingValues(all = 5.dp),
                ) {
                    items(characterItem.itemSnapshotList) {
                        CharacterItem(it!!)
                    }
                }
            }
        }



    }


    }







