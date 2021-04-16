package jis.lonepine.snsapp.presentation.ui.feed.adapter.holder

import androidx.recyclerview.widget.RecyclerView
import jis.lonepine.snsapp.data.entity.Card
import jis.lonepine.snsapp.databinding.HolderFeedItemBinding
import jis.lonepine.snsapp.presentation.ui.feed.FeedViewModel

class FeedItemHolder(private val binding:HolderFeedItemBinding):RecyclerView.ViewHolder(binding.root) {
    fun bind(item:Card,viewModel: FeedViewModel)
    {
        binding.item = item
        binding.viewModel = viewModel
    }
}