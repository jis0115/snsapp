package jis.lonepine.snsapp.presentation.extension

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity

fun FragmentActivity.add(id:Int, fragment:Fragment)
{
    supportFragmentManager.beginTransaction().apply {
//        replace(id, fragment)
        add(id,fragment)
        addToBackStack(null)
        commit()
    }
}

fun FragmentActivity.replace(id:Int,fragment:Fragment)
{
    supportFragmentManager.beginTransaction().apply {
        replace(id, fragment)
//        add(id,fragment)
        addToBackStack(null)
        commit()
    }
}

