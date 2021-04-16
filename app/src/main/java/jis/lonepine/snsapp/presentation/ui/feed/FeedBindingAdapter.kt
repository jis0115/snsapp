package jis.lonepine.snsapp.presentation.ui.feed

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import jis.lonepine.snsapp.data.entity.Card
import jis.lonepine.snsapp.presentation.ui.feed.adapter.FeedAdapter

@BindingAdapter("setFeedList","viewModel")
fun setFeedList(recyclerView: RecyclerView, items:List<Card>,viewModel:FeedViewModel)
{
    if (recyclerView.adapter == null)
    {
        recyclerView.adapter = FeedAdapter(viewModel)
        recyclerView.addOnScrollListener(object:RecyclerView.OnScrollListener(){
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                (recyclerView.layoutManager as? LinearLayoutManager)?.let {linearLayoutManager->
                    if (linearLayoutManager.findLastCompletelyVisibleItemPosition() == (viewModel.feedList.value?.size?:0) - 1) {
                        viewModel.loadMore()
                    }
                }
            }
        })
    }

    (recyclerView.adapter as? FeedAdapter)?.let {
        it.updateList(items)
    }
}