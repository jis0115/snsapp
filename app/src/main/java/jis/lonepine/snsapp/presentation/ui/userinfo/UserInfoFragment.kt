package jis.lonepine.snsapp.presentation.ui.userinfo

import android.content.Context
import jis.lonepine.snsapp.R
import jis.lonepine.snsapp.SnsAppApplication
import jis.lonepine.snsapp.databinding.FragmentUserInfoBinding
import jis.lonepine.snsapp.presentation.base.BindingFragment
import jis.lonepine.snsapp.presentation.extension.observe
import jis.lonepine.snsapp.presentation.extension.showToast
import javax.inject.Inject

class UserInfoFragment:BindingFragment<FragmentUserInfoBinding>(R.layout.fragment_user_info) {
    @Inject
    lateinit var viewModel:UserInfoViewModel

    override fun onAttach(context: Context) {
        (requireActivity().application as SnsAppApplication).appComponent.userInfoComponent().create().inject(this)
        super.onAttach(context)
    }

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