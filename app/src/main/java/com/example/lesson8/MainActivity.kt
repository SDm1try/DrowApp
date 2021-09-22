package com.example.lesson8

import android.os.Bundle
import android.widget.Button
import android.widget.RadioGroup
import androidx.appcompat.app.AppCompatActivity
import com.example.lesson8.figures.LineFigure
import com.example.lesson8.figures.PathFigure
import com.example.lesson8.figures.RectFigure

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val radioGroup = findViewById<RadioGroup>(R.id.radio_color_group)
        val myView = findViewById<MyView>(R.id.paint_view)
        val buttonReset = findViewById<Button>(R.id.button_reset)
        val figureGroup = findViewById<RadioGroup>(R.id.radio_figures_group)

        radioGroup.setOnCheckedChangeListener { _, i ->
            myView.color = when (i) {
                R.id.radio_color_red -> resources.getColor(R.color.red)
                R.id.radio_color_orange -> resources.getColor(R.color.orange)
                R.id.radio_color_yellow -> resources.getColor(R.color.yellow)
                R.id.radio_color_green -> resources.getColor(R.color.green)
                R.id.radio_color_blue -> resources.getColor(R.color.blue)
                R.id.radio_color_violet -> resources.getColor(R.color.violet)
                else -> throw NoSuchMethodException("not implemented")
            }
        }

        figureGroup.setOnCheckedChangeListener { _, i ->
            myView.figure = when (i) {
                R.id.radio_line -> LineFigure()
                R.id.radio_path -> PathFigure()
                R.id.radio_square -> RectFigure()
                else -> throw NoSuchMethodException("not implemented")
            }
        }

        buttonReset.setOnClickListener {
            myView.reset()
        }
    }
}