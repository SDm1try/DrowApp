package com.example.lesson8.figures

import android.graphics.Canvas

class LineFigure : Figure() {
    override fun startDraw(x: Float, y: Float) {
        startX = x
        startY = y
    }

    override fun finishDraw(x: Float, y: Float) {
        endX = x
        endY = y
    }

    override fun draw(canvas: Canvas?) {
        if (startX != null && endX != null && startY != null && endY != null)
            canvas?.drawLine(startX!!, startY!!, endX!!, endY!!, paint)
    }
}