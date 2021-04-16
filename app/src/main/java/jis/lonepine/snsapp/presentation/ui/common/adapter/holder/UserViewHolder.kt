package jis.lonepine.snsapp.presentation.ui.common.adapter.holder

import androidx.recyclerview.widget.RecyclerView
import jis.lonepine.snsapp.data.entity.User
import jis.lonepine.snsapp.databinding.HolderUserViewBinding
import jis.lonepine.snsapp.presentation.ui.common.UserItemViewModel

class UserViewHolder(private val binding:HolderUserViewBinding):RecyclerView.ViewHolder(binding.root) {
    fun bind(item:User,viewModel: UserItemViewModel)
    {
        binding.item = item
        binding.viewModel = viewModel
    }
}