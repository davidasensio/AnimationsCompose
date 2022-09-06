package com.example.animationscompose.ui.animations

import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.animationscompose.ui.common.ExpandedColumn

@Preview(showBackground = true, device = Devices.NEXUS_5X)
@Composable
fun AnimateFloatAsStateScaleCustomAnimationSpec() {
    var scaledDown by remember { mutableStateOf(false) }
    val scale: Float by animateFloatAsState(
        targetValue = if (scaledDown) 0.5f else 1f,
        animationSpec = tween(
            durationMillis = 3000,
            easing = if (scaledDown) FastOutSlowInEasing else LinearEasing
        )
    )

    ExpandedColumn {
        Box(
            Modifier
                .fillMaxSize(0.75f)
                .graphicsLayer(scaleX = scale, scaleY = scale)
                .background(Color.Red)
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = { scaledDown = !scaledDown }) {
            Text(text = if (scaledDown) "Reset" else "Scale down")
        }
    }
}
