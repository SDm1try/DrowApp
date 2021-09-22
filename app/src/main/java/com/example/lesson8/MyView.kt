package com.example.lesson8

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.util.Log
import android.view.MotionEvent
import android.view.View
import androidx.annotation.ColorInt
import com.example.lesson8.figures.Figure
import com.example.lesson8.figures.LineFigure
import com.example.lesson8.figures.PathFigure
import com.example.lesson8.figures.RectFigure

class MyView(context: Context, attrs: AttributeSet) : View(context, attrs) {
    @ColorInt
    var color: Int = resources.getColor(R.color.red)
    val figures = mutableListOf<Figure>()
    private val mStrokeWidth = 15F
    var figure: Figure = PathFigure()

    override fun onDraw(canvas: Canvas?) {
        figures.forEach {
            it.draw(canvas)
        }
        figure.paint.apply {
            color = this@MyView.color
            isAntiAlias = true
            strokeWidth = mStrokeWidth
            style = Paint.Style.STROKE
        }
        figure.draw(canvas)
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        val x = event?.x
        val y = event?.y
        if (x == null || y == null)
            return super.onTouchEvent(event)

        return when (event.action) {
            MotionEvent.ACTION_DOWN -> {
                figure.startDraw(x, y)
                return true
            }
            MotionEvent.ACTION_MOVE -> {
                figure.finishDraw(x, y)
                invalidate()
                return true
            }
            MotionEvent.ACTION_CANCEL -> {
                addFigure()
                return true
            }
            MotionEvent.ACTION_UP -> {
                addFigure()
                return true
            }
            MotionEvent.ACTION_MASK -> {

                return true
            }
            else -> {
                Log.d("onTouchEvent", event.action.toString())
                super.onTouchEvent(event)
            }
        }

    }

    private fun addFigure() {
        figures.add(figure)
        figure = when (figure) {
            is LineFigure -> LineFigure()
            is PathFigure -> PathFigure()
            is RectFigure -> RectFigure()
        }
    }

    fun reset() {
        figures.clear()
        figure.clear()
        invalidate()
    }
}