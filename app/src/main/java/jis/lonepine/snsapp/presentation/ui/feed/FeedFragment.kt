package jis.lonepine.snsapp.presentation.ui.feed

import android.content.Context
import android.os.Bundle
import jis.lonepine.snsapp.R
import jis.lonepine.snsapp.SnsAppApplication
import jis.lonepine.snsapp.databinding.FragmentFeedBinding
import jis.lonepine.snsapp.presentation.base.BindingFragment
import jis.lonepine.snsapp.presentation.extension.observe
import jis.lonepine.snsapp.presentation.extension.add
import jis.lonepine.snsapp.presentation.ui.card.CardFragment
import javax.inject.Inject

class FeedFragment:BindingFragment<FragmentFeedBinding>(R.layout.fragment_feed) {
    @Inject
    lateinit var viewModel:FeedViewModel

    override fun onAttach(context: Context) {
        (requireActivity().application as SnsAppApplication).appComponent.mainComponent().create().inject(this)
        super.onAttach(context)
    }

    override fun initView() {
        binding.viewModel = viewModel.apply {

            observe(loadFinish){
                binding.swipeRefreshLayout.isRefreshing = false
            }
            observe(showCardInfo){cardId->
                activity?.add(R.id.fragment_container_view,CardFragment().apply {
                    arguments = Bundle().apply {
                        putInt("id",cardId!!)
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