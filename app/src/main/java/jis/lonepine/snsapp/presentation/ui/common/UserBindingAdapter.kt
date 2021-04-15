package jis.lonepine.snsapp.presentation.ui.common

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import jis.lonepine.snsapp.data.entity.User
import jis.lonepine.snsapp.presentation.ui.common.adapter.UserAdapter

@BindingAdapter("setUsersItems","viewModel")
fun setCardItems(recyclerView: RecyclerView, items:List<User>, viewModel:UserItemViewModel)
{
    if (recyclerView.adapter == null)
    {
        recyclerView.adapter = UserAdapter(viewModel)
    }
    (recyclerView.adapter as? UserAdapter)?.let {
        it.updateList(items)
    }
}