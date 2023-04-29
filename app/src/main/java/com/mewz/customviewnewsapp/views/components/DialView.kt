package com.mewz.customviewnewsapp.views.components

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.PointF
import android.graphics.Typeface
import android.util.AttributeSet
import android.view.View
import androidx.core.content.withStyledAttributes
import com.mewz.customviewnewsapp.R
import kotlin.math.cos
import kotlin.math.min
import kotlin.math.sin

// 1 To represent the available fan speeds.
private enum class FanSpeed(val label: Int){
    OFF(R.string.fan_off),
    LOW(R.string.fan_low),
    MEDIUM(R.string.fan_medium),
    HIGH(R.string.fan_high);

    fun next() = when(this) {
        OFF -> LOW
        LOW -> MEDIUM
        MEDIUM -> HIGH
        HIGH -> OFF
    }
}

// 2
private const val RADIUS_OFFSET_LABEL = 30 // position for label
private const val RADIUS_OFFSET_INDICATOR = -35 // position for circle indicator

// 3
private var radius = 0.0f // Radius of the circle
private var fanSpeed = FanSpeed.OFF // The active selection

// position variable which will be used to draw label and indicator circle position
private val pointPosition: PointF = PointF(0.0f, 0.0f)

// 4 initialize fan colors
private var fanSpeedLowColor = Color.YELLOW
private var fanSpeedMediumColor = Color.GREEN
private var fanSpeedMaxColor = Color.RED

class DialView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    private val paint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        // Paint styles used for rendering are initialized here.
        // This is a performance optimization, since onDraw() is called
        // for every screen refresh
        style = Paint.Style.FILL
        textAlign = Paint.Align.CENTER
        textSize = 55.0f
        typeface = Typeface.create("", Typeface.BOLD)
    }

    // 2
    init {
        isClickable = true

        // 5
        context.withStyledAttributes(attrs, R.styleable.DialView){
            fanSpeedLowColor = getColor(R.styleable.DialView_fanColor1, fanSpeedLowColor)
            fanSpeedMediumColor = getColor(R.styleable.DialView_fanColor2, fanSpeedMediumColor)
            fanSpeedMaxColor = getColor(R.styleable.DialView_fanColor3, fanSpeedMaxColor)
        }
    }

    // 3
    override fun performClick(): Boolean {
        if (super.performClick()) return true

        fanSpeed = fanSpeed.next()

        invalidate()
        return true
    }

    // 1.calculate the current radius of the dial's circle element
    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        radius = (min(width, height) / 2.0 * 0.8).toFloat()
    }

    /**
     * 2
     * position is the fan speed(OFF,LOW,MEDIUM,HIGH)
     * radius is the whole view's radius
     *
     * calculate the X,Y coordinates on the screen for the text label and current indicator (0,1,2, or 3)
     * **/
    private fun PointF.computeXYForSpeed(pos: FanSpeed, radius: Float) {
        // Angles are in radians.
        val startAngle = Math.PI * (9 / 8.0)
        val angle = startAngle + pos.ordinal * (Math.PI / 4)
        x = (radius * cos(angle)).toFloat() + width / 2
        y = (radius * sin(angle)).toFloat() + height / 2
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        // 3
        drawBackground(canvas)

        // 4
        drawIndicatorCircle(canvas)

        // 5
        drawTextLabels(canvas)
    }

    private fun drawBackground(canvas: Canvas) {

        // Set dial background color to green if selection not off
        // paint.color = if (fanSpeed == FanSpeed.OFF) Color.GRAY else Color.GREEN

        // 6.Set dial background color based on the selection
        paint.color = when(fanSpeed){
            FanSpeed.OFF -> Color.GRAY
            FanSpeed.LOW -> fanSpeedLowColor
            FanSpeed.MEDIUM -> fanSpeedMediumColor
            FanSpeed.HIGH -> fanSpeedMaxColor
        }

        // Draw the circle
        canvas.drawCircle((width / 2).toFloat(), (height / 2).toFloat(), radius, paint)
    }


    private fun drawIndicatorCircle(canvas: Canvas) {

        // reduce radius -35 to make indicator inside of the circle
        val markerRadius = radius + RADIUS_OFFSET_INDICATOR

        // get new position (x,y)
        pointPosition.computeXYForSpeed(fanSpeed, markerRadius)

        // set indicator background color
        paint.color = Color.BLACK

        canvas.drawCircle(pointPosition.x, pointPosition.y, radius / 12, paint)
    }

    private fun drawTextLabels(canvas: Canvas) {

        // increase radius 30 to make labels outside of the circle
        val labelRadius = radius + RADIUS_OFFSET_LABEL

        for (i in FanSpeed.values()){
            pointPosition.computeXYForSpeed(i, labelRadius)
            val label = resources.getString(i.label)
            canvas.drawText(label, pointPosition.x, pointPosition.y, paint)
        }
    }
}