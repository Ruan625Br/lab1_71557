package com.lab1_71557.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.LockOpen
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.unit.dp

@Composable
fun Head(
    title: String,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier){
        Image(
            modifier = Modifier
                .size(75.dp)
                .align(Alignment.TopCenter),
            imageVector = Icons.Rounded.LockOpen,
            colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.onSurface),
            contentDescription = null)

        Text(
            modifier = Modifier
                .padding(top = 20.dp)
                .align(Alignment.BottomCenter),
            text = title)
    }
}