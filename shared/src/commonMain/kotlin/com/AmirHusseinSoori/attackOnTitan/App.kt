package com.AmirHusseinSoori.attackOnTitan


import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ContentAlpha
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import app.cash.paging.compose.collectAsLazyPagingItems


import com.AmirHusseinSoori.attackOnTitan.data.di.ViewModelModule
import com.AmirHusseinSoori.attackOnTitan.data.entity.Result
import com.AmirHusseinSoori.attackOnTitan.ui.ImageScreen.AtackOnTitanViewModel
import com.AmirHusseinSoori.attackOnTitan.ui.util.LARGE_PADDING
import com.AmirHusseinSoori.attackOnTitan.ui.util.MEDIUM_PADDING
import com.AmirHusseinSoori.attackOnTitan.ui.util.SMALL_PADDING
import com.AmirHusseinSoori.attackOnTitan.ui.util.TITAN_ITEM_HEIGHT
import com.AmirHusseinSoori.attackOnTitan.ui.util.shimmerBackground
import com.AmirHusseinSoori.attackOnTitan.ui.util.topAppBarContentColor
import com.seiko.imageloader.rememberImagePainter
import moe.tlaster.precompose.PreComposeApp


@Composable
internal fun App(imageViewModel: AtackOnTitanViewModel = ViewModelModule.injectAttackOnTitanViewModel()) {
    PreComposeApp {
        val characterItem= imageViewModel.getAllCharacter().collectAsLazyPagingItems()

        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(all = 5.dp),
        ) {
            items(characterItem.itemSnapshotList) {
                HeroItem(it!!)

            }
        }
    }
}

@Composable
fun HeroItem(
    result: Result,
) {

    Box(
        modifier = Modifier
            .height(TITAN_ITEM_HEIGHT)
            .clickable {

            },
        contentAlignment = Alignment.BottomStart
    ) {
        Surface(shape = RoundedCornerShape(size = LARGE_PADDING)) {

            Image(
                painter = rememberImagePainter(
                    result?.img ?: ""
                ),
                contentDescription = "content",
                modifier = Modifier
                    .fillMaxSize().padding(top = MEDIUM_PADDING).shimmerBackground(
                        RoundedCornerShape(5.dp)
                    ),
                contentScale = ContentScale.Crop,
            )
        }
        Surface(
            modifier = Modifier
                .fillMaxHeight(0.4f)
                .fillMaxWidth(),
            color = Color.Black.copy(alpha = ContentAlpha.medium),
            shape = RoundedCornerShape(
                bottomStart = LARGE_PADDING,
                bottomEnd = LARGE_PADDING
            )
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(all = MEDIUM_PADDING)
            ) {
                Text(
                    text = result.name,
                    color = MaterialTheme.colors.topAppBarContentColor,
                    fontSize = MaterialTheme.typography.h5.fontSize,
                    fontWeight = FontWeight.Bold,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                Text(
                    text = result.gender,
                    color = Color.White.copy(alpha = ContentAlpha.medium),
                    fontSize = MaterialTheme.typography.subtitle1.fontSize,
                    maxLines = 3,
                    overflow = TextOverflow.Ellipsis
                )
                Row(
                    modifier = Modifier.padding(top = SMALL_PADDING),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "(${result.species})",
                        textAlign = TextAlign.Center,
                        color = Color.White.copy(alpha = ContentAlpha.medium)
                    )
                }
            }
        }
    }
}



