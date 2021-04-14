package jis.lonepine.snsapp.presentation.ui.userinfo

import jis.lonepine.snsapp.R
import jis.lonepine.snsapp.databinding.FragmentUserInfoBinding
import jis.lonepine.snsapp.presentation.base.BindingFragment
import jis.lonepine.snsapp.presentation.extension.observe
import jis.lonepine.snsapp.presentation.extension.showToast
import org.koin.androidx.viewmodel.ext.android.viewModel

class UserInfoFragment:BindingFragment<FragmentUserInfoBinding>(R.layout.fragment_user_info) {
    private val viewModel:UserInfoViewModel by viewModel()
    override fun initView() {
        binding.viewModel = viewModel.apply {
            observe(showToast){
                context?.showToast(it!!)
            }

            observe(loadFinish){
                binding.swipeRefreshLayout.isRefreshing = false
            }

            binding.swipeRefreshLayout.setOnRefreshListener {
                getUserInfo()
            }

            getUserInfo()
        }
    }

    fun getUserInfo()
    {
        arguments?.getInt("id")?.let {
            viewModel.getUserInfo(id = it)
        }

    }
}