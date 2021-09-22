package com.example.lesson8.figures

import android.graphics.Canvas
import android.graphics.Path

data class PathFigure(var path: Path = Path()) : Figure() {
    override fun startDraw(x: Float, y: Float) {
        path.moveTo(x, y)
    }

    override fun finishDraw(x: Float, y: Float) {
        path.lineTo(x, y)
    }

    override fun draw(canvas: Canvas?) {
        canvas?.drawPath(path, paint)
    }
}
