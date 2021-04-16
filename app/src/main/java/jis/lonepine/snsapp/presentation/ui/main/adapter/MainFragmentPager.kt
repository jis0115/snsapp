package jis.lonepine.snsapp.presentation.ui.main.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class MainFragmentPagerAdapter(private val fm: FragmentManager) : FragmentPagerAdapter(fm) {
    private var items = listOf<Pair<Fragment,String>>()

    override fun getCount(): Int = items.size

    override fun getItem(position: Int): Fragment
    {
        return items[position].first
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return items[position].second
    }

    fun setFragments(newItems:List<Pair<Fragment,String>>)
    {
        items = newItems
    }

}