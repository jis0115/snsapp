package jis.lonepine.snsapp.presentation.ui.home.adapter

import androidx.recyclerview.widget.DiffUtil
import jis.lonepine.snsapp.presentation.ui.home.model.HomeUIModel

class HomeDiffUtil(private val oldList:List<HomeUIModel> , private val newList:List<HomeUIModel>):DiffUtil.Callback() {
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