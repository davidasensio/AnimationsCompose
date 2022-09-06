package com.example.animationscompose.ui.animations

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.animationscompose.ui.common.ExpandedColumn

@OptIn(ExperimentalAnimationApi::class)
@Preview(showBackground = true, device = Devices.NEXUS_5X)
@Composable
fun AnimatedContent() {
    var count by remember { mutableStateOf(0) }

    ExpandedColumn {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Button(onClick = { count++ }) {
                Text("Add")
            }
            Spacer(modifier = Modifier.width(16.dp))
            AnimatedContent(targetState = count) { targetCount ->
                // Make sure to use `targetCount`, not `count`.
                Text(text = "$targetCount", style = MaterialTheme.typography.h4)
            }
        }
    }
}
