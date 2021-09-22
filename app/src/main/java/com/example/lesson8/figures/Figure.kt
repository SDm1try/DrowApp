package com.example.lesson8.figures

import android.graphics.Canvas
import android.graphics.Paint
import android.os.Parcelable

sealed class Figure(var paint: Paint = Paint()) {
    protected var startX: Float? = null
    protected var startY: Float? = null
    protected var endX: Float? = null
    protected var endY: Float? = null


    abstract fun startDraw(x: Float, y: Float)
    abstract fun finishDraw(x: Float, y: Float)
    abstract fun draw(canvas: Canvas?)

    fun clear() {
        startX = null
        startY = null
        endX = null
        endY = null
    }
}
