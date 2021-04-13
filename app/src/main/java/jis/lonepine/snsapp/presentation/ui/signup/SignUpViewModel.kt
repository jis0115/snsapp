package jis.lonepine.snsapp.presentation.ui.signup

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import jis.lonepine.snsapp.domain.usecase.SignUpUseCase
import jis.lonepine.snsapp.presentation.base.DisposableViewModel

class SignUpViewModel(private val signUpUseCase: SignUpUseCase):DisposableViewModel() {
    fun signUp(nickName:String,introduction:String,pwd:String)
    {
        addDisposable(
            signUpUseCase.signUp(nickName, introduction, pwd)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({

                },{
                    it.printStackTrace()
                })
        )
    }
}