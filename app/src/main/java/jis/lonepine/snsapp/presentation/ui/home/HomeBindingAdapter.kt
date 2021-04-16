package jis.lonepine.snsapp.presentation.ui.home

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import jis.lonepine.snsapp.presentation.ui.common.CardItemViewModel
import jis.lonepine.snsapp.presentation.ui.common.UserItemViewModel
import jis.lonepine.snsapp.presentation.ui.home.adapter.HomeAdapter
import jis.lonepine.snsapp.presentation.ui.home.model.HomeUIModel

@BindingAdapter("setHomeItems","cardItemViewModel","userItemViewModel")
fun setHomeItems(recyclerView: RecyclerView,items:List<HomeUIModel>,cardItemViewModel:CardItemViewModel,userItemViewModel: UserItemViewModel)
{
    if (recyclerView.adapter == null)
    {
        recyclerView.adapter = HomeAdapter(cardItemViewModel,userItemViewModel)
    }

    (recyclerView.adapter as? HomeAdapter)?.let {
        it.updateList(items)
    }
}