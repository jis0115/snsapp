package jis.lonepine.snsapp.presentation.ui.common.adapter

import androidx.recyclerview.widget.DiffUtil
import jis.lonepine.snsapp.data.entity.User

class UserDiffUtil(private val oldList:List<User>, private val newList:List<User> ):DiffUtil.Callback() {
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