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
                context?.showToast("닉네임을 입력해주세요.")
            }

            observe(inputIntroduction)
            {
                context?.showToast("소개글을 입력해주세요.")
            }

            observe(inputPassword)
            {
                context?.showToast("비밀번호를 입력해주세요.")
            }

            observe(signUpSuccess)
            {
                closeFragment()
            }
        }
    }
}