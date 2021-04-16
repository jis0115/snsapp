package jis.lonepine.snsapp.presentation.ui.card

import android.content.Context
import android.os.Bundle
import jis.lonepine.snsapp.R
import jis.lonepine.snsapp.SnsAppApplication
import jis.lonepine.snsapp.databinding.FragmentCardBinding
import jis.lonepine.snsapp.presentation.base.BindingFragment
import jis.lonepine.snsapp.presentation.extension.observe
import jis.lonepine.snsapp.presentation.extension.add
import jis.lonepine.snsapp.presentation.extension.showToast
import jis.lonepine.snsapp.presentation.ui.common.CardItemViewModel
import jis.lonepine.snsapp.presentation.ui.common.UserItemViewModel
import jis.lonepine.snsapp.presentation.ui.userinfo.UserInfoFragment
import javax.inject.Inject

class CardFragment:BindingFragment<FragmentCardBinding>(R.layout.fragment_card) {
    @Inject
    lateinit var viewModel:CardViewModel
    @Inject
    lateinit var cardItemViewModel:CardItemViewModel
    @Inject
    lateinit var userItemViewModel: UserItemViewModel

    override fun onAttach(context: Context) {
        (requireActivity().application as SnsAppApplication).appComponent.cardComponent().create().inject(this)
        super.onAttach(context)
    }
    override fun initView() {
        binding.userItemViewModel = userItemViewModel.apply {
            observe(showUserInfo){
                activity?.add(R.id.fragment_container_view,UserInfoFragment().apply {
                    arguments = Bundle().apply {
                        putInt("id",it!!)
                    }
                })
            }
        }
        binding.cardItemViewModel = cardItemViewModel.apply {
            observe(showCardInfo){cardId->
                activity?.add(R.id.fragment_container_view,CardFragment().apply {
                    arguments = Bundle().apply {
                        putInt("id",cardId!!)
                    }
                })
            }
        }

        binding.viewModel = viewModel.apply {
            observe(showToast){
                context?.showToast(it!!)
            }

            observe(loadFinish){
                binding.swipeRefreshLayout.isRefreshing = false
            }

            binding.swipeRefreshLayout.setOnRefreshListener {
                loadData()
            }

            loadData()
        }
    }

    private fun loadData()
    {
        arguments?.getInt("id")?.let { id ->
            viewModel.load(id)
        }
    }
}