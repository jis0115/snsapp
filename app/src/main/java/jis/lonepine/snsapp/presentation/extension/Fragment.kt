package jis.lonepine.snsapp.presentation.extension

import android.os.Bundle
import androidx.fragment.app.Fragment

fun Fragment.closeFragment()
{
    parentFragmentManager.popBackStack()
}

//fun Fragment.changeFragment(bundle: Bundle? = null)
//{
//
//}