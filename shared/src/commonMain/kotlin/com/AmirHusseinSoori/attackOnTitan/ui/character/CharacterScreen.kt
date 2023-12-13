package com.AmirHusseinSoori.attackOnTitan.ui.character

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
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
import com.AmirHusseinSoori.attackOnTitan.data.entity.CharacterResult
import com.AmirHusseinSoori.attackOnTitan.ui.util.LARGE_PADDING
import com.AmirHusseinSoori.attackOnTitan.ui.util.MEDIUM_PADDING
import com.AmirHusseinSoori.attackOnTitan.ui.util.TITAN_ITEM_HEIGHT
import com.AmirHusseinSoori.attackOnTitan.ui.component.shimmerBackground
import com.AmirHusseinSoori.attackOnTitan.ui.util.topAppBarContentColor
import com.seiko.imageloader.rememberImagePainter

@Composable
fun CharacterItem(
    result: CharacterResult,
) {
    Box(
        modifier = Modifier.shimmerBackground()
            .height(TITAN_ITEM_HEIGHT)
            .clickable {

            },
        contentAlignment = Alignment.BottomStart
    ) {
        Surface(shape = RoundedCornerShape(size = LARGE_PADDING)) {

            Image(
                painter = rememberImagePainter(
                    result.img ?: ""
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
                    text = "status  : ${result.status}",
                    color = Color.White.copy(alpha = ContentAlpha.medium),
                    fontSize = MaterialTheme.typography.subtitle1.fontSize,
                    maxLines = 3,
                    overflow = TextOverflow.Ellipsis
                )
                Row(
                    modifier = Modifier,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "occupation : ${result.occupation}",
                        textAlign = TextAlign.Center,
                        color = Color.White.copy(alpha = ContentAlpha.medium)
                    )
                }
            }
        }
    }
}

