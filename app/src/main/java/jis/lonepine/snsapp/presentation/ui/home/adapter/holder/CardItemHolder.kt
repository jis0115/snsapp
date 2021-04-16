package jis.lonepine.snsapp.presentation.ui.home.adapter.holder

import androidx.recyclerview.widget.RecyclerView
import jis.lonepine.snsapp.data.entity.Card
import jis.lonepine.snsapp.databinding.HolderCardItemBinding
import jis.lonepine.snsapp.presentation.ui.common.CardItemViewModel
import jis.lonepine.snsapp.presentation.ui.home.HomeViewModel

class CardItemHolder(private val binding:HolderCardItemBinding):RecyclerView.ViewHolder(binding.root) {
    fun bind(items:List<Card>,viewModel: CardItemViewModel)
    {
        binding.items = items
        binding.viewModel = viewModel
    }
}