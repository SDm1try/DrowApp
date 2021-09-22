package com.example.lesson8.figures

import android.graphics.Canvas
import android.graphics.Rect
import kotlin.math.max
import kotlin.math.min

data class RectFigure(var rect: Rect = Rect()) : Figure() {
    override fun startDraw(x: Float, y: Float) {
        startX = x
        startY = y
    }

    override fun finishDraw(x: Float, y: Float) {
        endX = x
        endY = y
    }

    override fun draw(canvas: Canvas?) {
        if(startX != null && endX != null && startY != null && endY != null){
            rect.left = min(startX!!, endX!!).toInt()
            rect.right = max(startX!!, endX!!).toInt()
            rect.top = min(startY!!, endY!!).toInt()
            rect.bottom = max(startY!!, endY!!).toInt()

            canvas?.drawRect(rect, paint)
        }

    }

}
