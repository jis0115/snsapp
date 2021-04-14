package jis.lonepine.snsapp.presentation.ui.signup

import android.util.Log
import androidx.lifecycle.LiveData
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import jis.lonepine.snsapp.domain.usecase.SignUpUseCase
import jis.lonepine.snsapp.presentation.base.DisposableViewModel
import jis.lonepine.snsapp.presentation.base.SingleLiveEvent

class SignUpViewModel(private val signUpUseCase: SignUpUseCase):DisposableViewModel() {
    private val _inputNickName = SingleLiveEvent<Any>()
    val inputNickName:LiveData<Any> = _inputNickName

    private val _inputIntroduction = SingleLiveEvent<Any>()
    val inputIntroduction:LiveData<Any> = _inputIntroduction

    private val _inputPassword = SingleLiveEvent<Any>()
    val inputPassword:LiveData<Any> = _inputPassword

    private val _signUpSuccess = SingleLiveEvent<Int>()
    val signUpSuccess:LiveData<Int> = _signUpSuccess
    fun signUp(nickName:String,introduction:String,pwd:String)
    {
//        TODO: 기존 앱에서는 체크하지 않지만 있어야할것 같아추가함.
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
            signUpUseCase.signUp(nickName, introduction, pwd)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    if(it.ok)
                    {
                        _signUpSuccess.value = it.user_id
                    }
                    else if (it.error_msg?.isNotEmpty() == true)
                    {
                        _showToast.postValue(it.error_msg)
                    }
                },{
                    it.printStackTrace()
                })
        )
    }
}