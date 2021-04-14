package jis.lonepine.snsapp.presentation.ui.feed.adapter

import androidx.recyclerview.widget.DiffUtil
import jis.lonepine.snsapp.data.entity.Card

class FeedDiffUtil(private val oldList:List<Card>, private val newList:List<Card>):DiffUtil.Callback() {
    override fun getOldListSize(): Int {
        return oldList.size
    }

    override fun getNewListSize(): Int {
        return newList.size
    }

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition] == newList[newItemPosition]
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition] == newList[newItemPosition]
    }

}