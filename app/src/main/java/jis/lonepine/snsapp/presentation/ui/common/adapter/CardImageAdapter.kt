package jis.lonepine.snsapp.presentation.ui.common.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import jis.lonepine.snsapp.data.entity.Card
import jis.lonepine.snsapp.databinding.HolderImageViewBinding
import jis.lonepine.snsapp.presentation.ui.common.adapter.holder.ImageViewHolder
import jis.lonepine.snsapp.presentation.ui.common.CardItemViewModel

class CardImageAdapter(private val viewModel: CardItemViewModel):RecyclerView.Adapter<ImageViewHolder>() {
    private var items = listOf<Card>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        return ImageViewHolder(HolderImageViewBinding.inflate(LayoutInflater.from(parent.context),parent,false)).apply {
            val width = (parent.rootView.width / 4.5).toInt()
            itemView.layoutParams.width = width
            itemView.layoutParams.height = width
        }
    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        holder.bind(items[position],viewModel)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun updateList(newItems:List<Card>)
    {
        val diffUtil = CardDiffUtil(newItems,items)
        val result = DiffUtil.calculateDiff(diffUtil)
        items = newItems
        result.dispatchUpdatesTo(this)
    }
}