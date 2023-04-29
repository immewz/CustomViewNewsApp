package com.mewz.customviewnewsapp.views.components

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Rect
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatEditText
import androidx.core.content.withStyledAttributes
import com.mewz.customviewnewsapp.R

class PrefixCustomEditText @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null
) : AppCompatEditText(context, attrs) {

    // initialize prefix and it's color
    private var mPrefix = "+95"
    private var mPrefixColor = Color.BLACK

    private val mPrefixRect = Rect()

    init {
        context.withStyledAttributes(attrs, R.styleable.PrefixCustomEditText){
            mPrefix = getString(R.styleable.PrefixCustomEditText_prefix) ?: mPrefix
            mPrefixColor = getColor(R.styleable.PrefixCustomEditText_prefixColor, mPrefixColor)
        }
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        // 1. place the prefix text
        paint.getTextBounds(mPrefix, 0, mPrefix.length, mPrefixRect)

        // 2. add space between prefix and user's input text
        mPrefixRect.right += paint.measureText(" ").toInt()

        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
    }

    override fun onDraw(canvas: Canvas?) {
        // set prefix text color
        paint.color = mPrefixColor

        // 3. start draw the EditText field including the prefix
        canvas?.drawText(
            mPrefix,
            super.getCompoundPaddingLeft().toFloat(),
            baseline.toFloat(),
            paint
        )
        super.onDraw(canvas)
    }

    // 4. define start position to type text
    override fun getCompoundPaddingLeft(): Int {
        return super.getCompoundPaddingLeft() + mPrefixRect.width()
    }
}