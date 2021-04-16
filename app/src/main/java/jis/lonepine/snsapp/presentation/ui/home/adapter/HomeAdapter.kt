package jis.lonepine.snsapp.presentation.ui.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import jis.lonepine.snsapp.R
import jis.lonepine.snsapp.databinding.HolderCardItemBinding
import jis.lonepine.snsapp.databinding.HolderUserItemBinding
import jis.lonepine.snsapp.presentation.ui.common.CardItemViewModel
import jis.lonepine.snsapp.presentation.ui.common.UserItemViewModel
import jis.lonepine.snsapp.presentation.ui.home.adapter.holder.CardItemHolder
import jis.lonepine.snsapp.presentation.ui.home.adapter.holder.UserItemHolder
import jis.lonepine.snsapp.presentation.ui.home.model.HomeUIModel

class HomeAdapter(private val cardItemViewModel: CardItemViewModel,private val userItemViewModel: UserItemViewModel):RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private var items = listOf<HomeUIModel>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when(viewType)
        {
            R.layout.holder_card_item->{
                CardItemHolder(HolderCardItemBinding.inflate(LayoutInflater.from(parent.context),parent,false))
            }
            else->{
                UserItemHolder(HolderUserItemBinding.inflate(LayoutInflater.from(parent.context),parent,false))
            }
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder)
        {
            is CardItemHolder->{
                (holder).bind(items = (items[position] as HomeUIModel.CardUIModel).cardList,viewModel = cardItemViewModel)
            }
            is UserItemHolder->{
                (holder).bind(items = (items[position] as HomeUIModel.UserUIModel).userList,viewModel = userItemViewModel)
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        return when(items[position]){
            is HomeUIModel.CardUIModel-> R.layout.holder_card_item
            else -> R.layout.holder_user_item
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun updateList(newItems:List<HomeUIModel>)
    {
        val diffUtil = HomeDiffUtil(items,newItems)
        val result = DiffUtil.calculateDiff(diffUtil)
        items = newItems
        result.dispatchUpdatesTo(this)
    }
}