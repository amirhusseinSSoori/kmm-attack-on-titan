package com.AmirHusseinSoori.attackOnTitan


import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.seiko.imageloader.rememberImagePainter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.AmirHusseinSoori.attackOnTitan.ui.ImageScreen.ImageViewModel
import com.AmirHusseinSoori.attackOnTitan.ui.util.shimmerBackground
import moe.tlaster.precompose.PreComposeApp


@Composable
internal fun App(imageViewModel: ImageViewModel = ImageViewModel()) {
    PreComposeApp {
        Column {
            Text("AttacKOnTitan")
            Image(
                painter = rememberImagePainter(
                    imageViewModel.getUrl()
                ),
                contentDescription = "card",
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



