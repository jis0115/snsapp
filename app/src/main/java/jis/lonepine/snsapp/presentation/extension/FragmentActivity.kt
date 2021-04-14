package jis.lonepine.snsapp.presentation.extension

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity

fun FragmentActivity.showFragment(id:Int,fragment:Fragment)
{
    supportFragmentManager.beginTransaction().apply {
        replace(id, fragment)
        addToBackStack(null)
        commit()
    }
}

