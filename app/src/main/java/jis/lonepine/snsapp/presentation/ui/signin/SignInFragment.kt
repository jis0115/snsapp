package jis.lonepine.snsapp.presentation.ui.signin

import android.content.Context
import jis.lonepine.snsapp.R
import jis.lonepine.snsapp.SnsAppApplication
import jis.lonepine.snsapp.databinding.FragmentSignInBinding
import jis.lonepine.snsapp.presentation.base.BindingFragment
import jis.lonepine.snsapp.presentation.extension.closeFragment
import jis.lonepine.snsapp.presentation.extension.observe
import jis.lonepine.snsapp.presentation.extension.showToast
import javax.inject.Inject

class SignInFragment:BindingFragment<FragmentSignInBinding>(R.layout.fragment_sign_in) {
    @Inject
    lateinit var viewModel:SignInViewModel

    override fun onAttach(context: Context) {
        (requireActivity().application as SnsAppApplication).appComponent.signInComponent().create().inject(this)
        super.onAttach(context)
    }

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