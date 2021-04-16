package jis.lonepine.snsapp.presentation.extension

import androidx.fragment.app.Fragment

fun Fragment.closeFragment()
{
    parentFragmentManager.popBackStack()
}