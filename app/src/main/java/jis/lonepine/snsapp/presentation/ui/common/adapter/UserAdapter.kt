package jis.lonepine.snsapp.presentation.ui.common.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import jis.lonepine.snsapp.data.entity.Card
import jis.lonepine.snsapp.data.entity.User
import jis.lonepine.snsapp.databinding.HolderImageViewBinding
import jis.lonepine.snsapp.databinding.HolderUserViewBinding
import jis.lonepine.snsapp.presentation.ui.common.adapter.holder.ImageViewHolder
import jis.lonepine.snsapp.presentation.ui.common.CardItemViewModel
import jis.lonepine.snsapp.presentation.ui.common.UserItemViewModel
import jis.lonepine.snsapp.presentation.ui.common.adapter.holder.UserViewHolder

class UserAdapter(private val viewModel: UserItemViewModel):RecyclerView.Adapter<UserViewHolder>() {
    private var items = listOf<User>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        return UserViewHolder(HolderUserViewBinding.inflate(LayoutInflater.from(parent.context),parent,false)).apply {
            val width = (parent.rootView.width / 4.5).toInt()
            itemView.layoutParams.width = width
            itemView.layoutParams.height = width
        }
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.bind(items[position],viewModel)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun updateList(newItems:List<User>)
    {
        val diffUtil = UserDiffUtil(newItems,items)
        val result = DiffUtil.calculateDiff(diffUtil)
        items = newItems
        result.dispatchUpdatesTo(this)
    }
}