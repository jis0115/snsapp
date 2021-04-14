package jis.lonepine.snsapp.presentation.ui.signin

import jis.lonepine.snsapp.R
import jis.lonepine.snsapp.databinding.FragmentSignInBinding
import jis.lonepine.snsapp.presentation.base.BindingFragment
import jis.lonepine.snsapp.presentation.extension.closeFragment
import jis.lonepine.snsapp.presentation.extension.observe
import jis.lonepine.snsapp.presentation.extension.showToast
import org.koin.androidx.viewmodel.ext.android.viewModel

class SignInFragment:BindingFragment<FragmentSignInBinding>(R.layout.fragment_sign_in) {
    private val viewModel:SignInViewModel by viewModel()
    override fun initView() {
        binding.viewModel = viewModel.apply {
            observe(signInSuccess)
            {
                closeFragment()
            }

            observe(showToast)
            {
                context?.showToast(it!!)
            }
        }
    }
}