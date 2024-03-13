package com.lab1_71557

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.DarkMode
import androidx.compose.material.icons.outlined.LightMode
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp
import androidx.core.view.WindowCompat
import com.lab1_71557.ui.navigation.NavigationHost
import com.lab1_71557.ui.theme.Lab1_71557Theme
import com.lab1_71557.utils.screen_shot.ScreenshotScope
import com.lab1_71557.utils.screen_shot.rememberScreenshotState
import com.lab1_71557.utils.shape.RemovableDiagonalRectShape
import com.lab1_71557.utils.shape.ShapeDirection
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WindowCompat.setDecorFitsSystemWindows(window, false)
            val isSystemInDarkTheme = isSystemInDarkTheme()
            val screenShotState = rememberScreenshotState()
            val isDarkMode = remember { mutableStateOf(isSystemInDarkTheme) }
            val offset = remember { mutableFloatStateOf(0f) }
            val scope = rememberCoroutineScope()
            val screenWidth = LocalConfiguration.current.screenWidthDp
            val screenWishPx = with(LocalDensity.current) { screenWidth.dp.toPx() }
            val animationOffset = animateFloatAsState(
                targetValue = offset.floatValue, label = "animation offset", finishedListener = {
                    offset.floatValue = 0f
                    screenShotState.setBitmap(null)
                }, animationSpec = tween(1200)
            )

            Lab1_71557Theme(
                darkTheme = isDarkMode.value, dynamicColor = false
            ) {
                ScreenshotScope(
                    screenShotState = screenShotState, modifier = Modifier.fillMaxSize()
                ) {
                    Scaffold(
                        modifier = Modifier.fillMaxSize(),
                    ) {

                        Box(modifier = Modifier.fillMaxSize()) {

                            IconButton(
                                modifier = Modifier
                                    .padding(top = 40.dp),
                                onClick = {
                                    scope.launch {
                                        screenShotState.capture()
                                        offset.floatValue = screenWishPx
                                        delay(100)
                                        isDarkMode.value = !isDarkMode.value
                                    }
                                }) {
                                val icon =
                                    if (isDarkMode.value) Icons.Outlined.LightMode else Icons.Outlined.DarkMode
                                Icon(imageVector = icon, contentDescription = null)
                            }
                            NavigationHost()
                        }
                    }

                    screenShotState.bitmap.value?.asImageBitmap()?.let {
                        Image(
                            bitmap = it,
                            contentDescription = null,
                            modifier = Modifier
                                .fillMaxSize()
                                .clip(
                                    shape = RemovableDiagonalRectShape(
                                        offset = animationOffset.value,
                                        direction = if (isDarkMode.value) ShapeDirection.ToLeft else ShapeDirection.ToRight
                                    )
                                )
                        )
                    }
                }
            }
        }
    }
}