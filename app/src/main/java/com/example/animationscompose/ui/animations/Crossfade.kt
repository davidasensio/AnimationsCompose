package com.example.animationscompose.ui.animations

import androidx.compose.animation.Crossfade
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.graphics.ColorUtils
import com.example.animationscompose.ui.common.ExpandedColumn

@Preview(showBackground = true, device = Devices.NEXUS_5X)
@Composable
fun Crossfade() {
    var currentPage by remember { mutableStateOf(0) }

    ExpandedColumn {
        Crossfade(
            targetState = currentPage,
            animationSpec = tween(durationMillis = 1000)
        ) { screen -> ColorBox(screen) }
        Button(onClick = {
            currentPage = (0..0xFFFFFF).random()
        }) {
            Text("Click Me")
        }
    }
}

@Composable
private fun ColorBox(screen: Int) {
    Box(
        Modifier
            .size(150.dp)
            .background(Color(screen + 0xFF000000)),
        contentAlignment = Alignment.Center
    ) {
        Text(get6DigitHex(screen), color = contrastColor(screen))
    }
}

private fun get6DigitHex(value: Int): String {
    return "0x" + "%x".format(value).padStart(6, '0').uppercase()
}

private fun contrastColor(color: Int): Color {
    return if (ColorUtils.calculateLuminance(color) < 0.5)
        Color.White
    else
        Color.Black
}
