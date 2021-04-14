package jis.lonepine.snsapp.presentation.ui.card

import android.os.Bundle
import jis.lonepine.snsapp.R
import jis.lonepine.snsapp.databinding.FragmentCardBinding
import jis.lonepine.snsapp.presentation.base.BindingFragment
import jis.lonepine.snsapp.presentation.extension.observe
import jis.lonepine.snsapp.presentation.extension.showFragment
import jis.lonepine.snsapp.presentation.extension.showToast
import jis.lonepine.snsapp.presentation.ui.userinfo.UserInfoFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class CardFragment:BindingFragment<FragmentCardBinding>(R.layout.fragment_card) {
    private val viewModel:CardViewModel by viewModel()
    override fun initView() {
        binding.viewModel = viewModel.apply {
            observe(showToast){
                context?.showToast(it!!)
            }

            observe(loadFinish){
                binding.swipeRefreshLayout.isRefreshing = false
            }

            observe(showUserInfo){
                activity?.showFragment(R.id.fragment_container_view,UserInfoFragment().apply {
                    arguments = Bundle().apply {
                        putInt("id",it!!)
                    }
                })
            }

            binding.swipeRefreshLayout.setOnRefreshListener {
                loadData()
            }

            arguments?.getInt("id")?.let { id ->
                loadData()
            }

        }
    }

    private fun loadData()
    {
        arguments?.getInt("id")?.let { id ->
            viewModel.load(id)
        }
    }
}