package jis.lonepine.snsapp.presentation.ui.signup

import androidx.lifecycle.LiveData
import jis.lonepine.snsapp.domain.usecase.SignUpUseCase
import jis.lonepine.snsapp.presentation.base.DisposableViewModel
import jis.lonepine.snsapp.presentation.base.SingleLiveEvent
import jis.lonepine.snsapp.presentation.di.ActivityScope
import javax.inject.Inject

@ActivityScope
class SignUpViewModel @Inject constructor(private val signUpUseCase: SignUpUseCase):DisposableViewModel() {
    private val _inputNickName = SingleLiveEvent<Any>()
    val inputNickName:LiveData<Any> = _inputNickName

    private val _inputIntroduction = SingleLiveEvent<Any>()
    val inputIntroduction:LiveData<Any> = _inputIntroduction

    private val _inputPassword = SingleLiveEvent<Any>()
    val inputPassword:LiveData<Any> = _inputPassword

    private val _signUpSuccess = SingleLiveEvent<Any>()
    val signUpSuccess:LiveData<Any> = _signUpSuccess
    fun signUp(nickName:String,introduction:String,pwd:String)
    {
        if (nickName.isBlank())
        {
            _inputNickName.call()
            return
        }

        if (introduction.isBlank())
        {
            _inputIntroduction.call()
            return
        }

        if (pwd.isBlank())
        {
            _inputPassword.call()
            return
        }

        addDisposable(
            signUpUseCase.signUp(nickName, introduction, pwd,{
                _signUpSuccess.call()
            },{
                _showToast.postValue(it)
            })
        )
    }
}