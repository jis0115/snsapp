package jis.lonepine.snsapp.presentation.ui.feed

import android.os.Bundle
import jis.lonepine.snsapp.R
import jis.lonepine.snsapp.databinding.FragmentFeedBinding
import jis.lonepine.snsapp.presentation.base.BindingFragment
import jis.lonepine.snsapp.presentation.extension.observe
import jis.lonepine.snsapp.presentation.extension.showFragment
import jis.lonepine.snsapp.presentation.ui.card.CardFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class FeedFragment:BindingFragment<FragmentFeedBinding>(R.layout.fragment_feed) {
    private val viewModel:FeedViewModel by viewModel()
    override fun initView() {
        binding.viewModel = viewModel.apply {

            observe(loadFinish){
                binding.swipeRefreshLayout.isRefreshing = false
            }
            observe(showCardInfo){
                activity?.showFragment(R.id.fragment_container_view,CardFragment().apply {
                    arguments = Bundle().apply {
                        putInt("id",it!!)
                    }
                })
            }

            binding.swipeRefreshLayout.setOnRefreshListener {
                reLoadList()
            }

            loadList()
        }




    }
}