package jis.lonepine.snsapp.presentation.extension

import android.content.Context
import android.widget.Toast

fun Context.showToast(text:String)
{
    Toast.makeText(this,text,Toast.LENGTH_SHORT).show()
}

fun Context.showToast(resourceId:Int)
{
    Toast.makeText(this,resourceId,Toast.LENGTH_SHORT).show()
}