package jis.lonepine.snsapp.presentation.ui.feed

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import jis.lonepine.snsapp.data.entity.Card
import jis.lonepine.snsapp.presentation.ui.feed.adapter.FeedAdapter

@BindingAdapter("setFeedList","viewModel")
fun setFeedList(recyclerView: RecyclerView, items:List<Card>,viewModel:FeedViewModel)
{
    if (recyclerView.adapter == null)
    {
        recyclerView.adapter = FeedAdapter(viewModel)
    }

    (recyclerView.adapter as? FeedAdapter)?.let {
        it.updateList(items)
    }
}