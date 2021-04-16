package jis.lonepine.snsapp.presentation.ui.home

import android.content.Context
import android.os.Bundle
import jis.lonepine.snsapp.R
import jis.lonepine.snsapp.SnsAppApplication
import jis.lonepine.snsapp.databinding.FragmentHomeBinding
import jis.lonepine.snsapp.presentation.base.BindingFragment
import jis.lonepine.snsapp.presentation.extension.observe
import jis.lonepine.snsapp.presentation.extension.add
import jis.lonepine.snsapp.presentation.ui.card.CardFragment
import jis.lonepine.snsapp.presentation.ui.common.CardItemViewModel
import jis.lonepine.snsapp.presentation.ui.common.UserItemViewModel
import jis.lonepine.snsapp.presentation.ui.userinfo.UserInfoFragment
import javax.inject.Inject

class HomeFragment:BindingFragment<FragmentHomeBinding>(R.layout.fragment_home) {
    @Inject
    lateinit var cardItemViewModel:CardItemViewModel
    @Inject
    lateinit var userItemViewModel:UserItemViewModel
    @Inject
    lateinit var viewModel:HomeViewModel

    override fun onAttach(context: Context) {
        (requireActivity().application as SnsAppApplication).appComponent.mainComponent().create().inject(this)
        super.onAttach(context)
    }
    override fun initView() {


        binding.userItemViewModel = userItemViewModel.apply {
            observe(showUserInfo){
                activity?.add(R.id.fragment_container_view, UserInfoFragment().apply {
                    arguments = Bundle().apply {
                        putInt("id",it!!)
                    }
                })
            }
        }

        binding.cardItemViewModel = cardItemViewModel.apply {
            observe(showCardInfo){cardId->
                activity?.add(R.id.fragment_container_view, CardFragment().apply {
                    arguments = Bundle().apply {
                        putInt("id",cardId!!)
                    }
                })
            }
        }

        binding.viewModel = viewModel.apply {
            observe(loadFinish)
            {
                binding.swipeRefreshLayout.isRefreshing = false
            }


            binding.swipeRefreshLayout.setOnRefreshListener {
                loadHomeData()
            }
            loadHomeData()
        }



    }
}