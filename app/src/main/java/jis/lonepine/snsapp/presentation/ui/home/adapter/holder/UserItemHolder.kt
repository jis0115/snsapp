package jis.lonepine.snsapp.presentation.ui.home.adapter.holder

import androidx.recyclerview.widget.RecyclerView
import jis.lonepine.snsapp.data.entity.User
import jis.lonepine.snsapp.databinding.HolderUserItemBinding
import jis.lonepine.snsapp.presentation.ui.common.UserItemViewModel
import jis.lonepine.snsapp.presentation.ui.home.HomeViewModel

class UserItemHolder(private val binding:HolderUserItemBinding):RecyclerView.ViewHolder(binding.root) {
    fun bind(items:List<User>, viewModel: UserItemViewModel)
    {
        binding.items = items
        binding.viewModel = viewModel
    }
}