package com.example.animationscompose.ui.animations

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.animationscompose.ui.common.ExpandedColumn

@Preview(showBackground = true, device = Devices.NEXUS_5X)
@Composable
fun AnimatedVisibility() {
    var isVisible by remember { mutableStateOf(true) }

    ExpandedColumn {
        AnimatedVisibility(visible = isVisible) {
            Text(text = "Animating Text", style = MaterialTheme.typography.h4)
        }
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = { isVisible = !isVisible }) {
            Text(text = "Animate")
        }
    }
}
