package com.lab1_71557.utils.shape

sealed interface ShapeDirection {
    data object ToLeft : ShapeDirection
    data object ToRight : ShapeDirection
}