package com.lab1_71557.utils.screen_shot

import android.graphics.Bitmap
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf

class ScreenShotState internal constructor() {
    private val _bitmap = mutableStateOf<Bitmap?>(null)
    val bitmap: State<Bitmap?> = _bitmap
    internal var callback: (() -> Unit)? = null

    fun setBitmap(bitmap: Bitmap?){
        _bitmap.value = bitmap
    }

    fun capture(){
        callback?.invoke()
    }
}