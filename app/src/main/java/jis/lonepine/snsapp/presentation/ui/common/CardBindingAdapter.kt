package jis.lonepine.snsapp.presentation.ui.card

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import jis.lonepine.snsapp.data.entity.Card
import jis.lonepine.snsapp.presentation.ui.common.adapter.CardImageAdapter
import jis.lonepine.snsapp.presentation.ui.common.CardItemViewModel

@BindingAdapter("setCardItems","viewModel")
fun setCardItems(recyclerView: RecyclerView,items:List<Card>,viewModel:CardItemViewModel)
{
    if (recyclerView.adapter == null)
    {
        recyclerView.adapter = CardImageAdapter(viewModel)
    }
    (recyclerView.adapter as? CardImageAdapter)?.let {
        it.updateList(items)
    }
}