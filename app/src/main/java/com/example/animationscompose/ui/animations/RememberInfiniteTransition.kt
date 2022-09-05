package com.example.animationscompose.ui.animations

import androidx.compose.animation.core.FastOutLinearInEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.StartOffset
import androidx.compose.animation.core.StartOffsetType
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.animationscompose.ui.common.ExpandedColumn

@Preview(showBackground = true, device = Devices.NEXUS_5X)
@Composable
fun RememberInfiniteTransition() {
    ExpandedColumn {
        DotLoader()
    }
}

@Composable
internal fun DotLoader(modifier: Modifier = Modifier, color: Color = MaterialTheme.colors.primary) {
    Row(modifier = modifier, horizontalArrangement = Arrangement.Center, verticalAlignment = Alignment.CenterVertically) {
        repeat(3) { dotIndex ->
            Dot(color = color,
                size = 48.dp,
                scale = getDotInfiniteAnimation(offsetMillis = 140 * dotIndex),
                modifier = if (dotIndex > 0) Modifier.padding(start = 24.dp) else Modifier
            )
        }
    }
}

@Composable
private fun getDotInfiniteAnimation(offsetMillis: Int = 0): State<Float> {
    val dotInitialScale = 1f
    val dotTargetScale = 0.6f
    val dotDurationMillis = 240
    val dotDelayMillis = 140 * 2
    val dotAnimationSpec = infiniteRepeatable<Float>(
        animation = tween(
            durationMillis = dotDurationMillis,
            easing = FastOutLinearInEasing,
            delayMillis = dotDelayMillis
        ),
        repeatMode = RepeatMode.Reverse,
        initialStartOffset = StartOffset(
            offsetMillis = offsetMillis,
            offsetType = StartOffsetType.Delay
        )
    )
    return rememberInfiniteTransition().animateFloat(
        initialValue = dotInitialScale,
        targetValue = dotTargetScale,
        animationSpec = dotAnimationSpec
    )
}

@Composable
private fun Dot(color: Color, size: Dp, scale: State<Float>, modifier: Modifier = Modifier) {
    Box(modifier = modifier
        .size(size)
        .graphicsLayer {
            scaleX = scale.value
            scaleY = scale.value
        }
        .background(
            color = color,
            shape = CircleShape
        )
    )
}
