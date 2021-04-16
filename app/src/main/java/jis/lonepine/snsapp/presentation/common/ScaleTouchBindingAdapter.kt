package jis.lonepine.snsapp.presentation.common

import android.annotation.SuppressLint
import android.view.MotionEvent
import android.view.View
import androidx.databinding.BindingAdapter

@SuppressLint("ClickableViewAccessibility")
@BindingAdapter("setTouchScale")
fun setTouchScale(view:View,scale:Float)
{

    view.setOnTouchListener { v, event ->
        return@setOnTouchListener when(event.action)
        {
            MotionEvent.ACTION_DOWN->{
                v.pivotX = v.width.toFloat() / 2f
                v.pivotY = v.height.toFloat() / 2f
                v.animate().scaleX(scale).scaleY(scale).setDuration(100).start()
                false
            }
            MotionEvent.ACTION_CANCEL,MotionEvent.ACTION_UP->{
                v.animate().scaleX(1.0f).scaleY(1.0f).setDuration(100).start()
                false
            }
            else->false
        }
    }
}