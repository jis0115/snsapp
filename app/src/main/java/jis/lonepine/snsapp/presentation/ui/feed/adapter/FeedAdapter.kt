package jis.lonepine.snsapp.presentation.ui.feed.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import jis.lonepine.snsapp.data.entity.Card
import jis.lonepine.snsapp.databinding.HolderFeedItemBinding
import jis.lonepine.snsapp.presentation.ui.feed.FeedViewModel
import jis.lonepine.snsapp.presentation.ui.feed.adapter.holder.FeedItemHolder

class FeedAdapter(private val viewModel:FeedViewModel):RecyclerView.Adapter<FeedItemHolder>() {

    private var items = listOf<Card>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FeedItemHolder {
        return FeedItemHolder(HolderFeedItemBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: FeedItemHolder, position: Int) {
        holder.bind(item = items[position],viewModel)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun updateList(newList:List<Card>)
    {
        val callback = FeedDiffUtil(items,newList)
        val result = DiffUtil.calculateDiff(callback)
        items = newList
        result.dispatchUpdatesTo(this)
    }
}