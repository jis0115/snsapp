package jis.lonepine.snsapp.presentation.ui.common.adapter.holder

import androidx.recyclerview.widget.RecyclerView
import jis.lonepine.snsapp.data.entity.Card
import jis.lonepine.snsapp.databinding.HolderImageViewBinding
import jis.lonepine.snsapp.presentation.ui.common.CardItemViewModel

class ImageViewHolder(private val binding:HolderImageViewBinding):RecyclerView.ViewHolder(binding.root) {
    fun bind(item:Card,viewModel: CardItemViewModel)
    {
        binding.item = item
        binding.viewModel = viewModel
    }
}