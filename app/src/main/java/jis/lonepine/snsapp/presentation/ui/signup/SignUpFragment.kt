package jis.lonepine.snsapp.presentation.ui.signup

import android.content.Context
import jis.lonepine.snsapp.R
import jis.lonepine.snsapp.SnsAppApplication
import jis.lonepine.snsapp.databinding.FragmentSignUpBinding
import jis.lonepine.snsapp.presentation.base.BindingFragment
import jis.lonepine.snsapp.presentation.extension.closeFragment
import jis.lonepine.snsapp.presentation.extension.observe
import jis.lonepine.snsapp.presentation.extension.showToast
import javax.inject.Inject

class SignUpFragment:BindingFragment<FragmentSignUpBinding>(R.layout.fragment_sign_up) {
    @Inject
    lateinit var viewModel:SignUpViewModel

    override fun onAttach(context: Context) {
        (requireActivity().application as SnsAppApplication).appComponent.signUpComponent().create().inject(this)
        super.onAttach(context)
    }

    override fun initView() {
        binding.viewModel = viewModel.apply{
            observe(showToast)
            {
                context?.showToast(it!!)
            }

            observe(inputNickName)
            {
                context?.showToast(R.string.insert_nick_name)
            }

            observe(inputIntroduction)
            {
                context?.showToast(R.string.insert_introduction)
            }

            observe(inputPassword)
            {
                context?.showToast(R.string.insert_password)
            }

            observe(signUpSuccess)
            {
                closeFragment()
            }
        }
    }
}