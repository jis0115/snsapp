package jis.lonepine.snsapp.presentation.ui.signin

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import jis.lonepine.snsapp.domain.usecase.SignInUseCase
import jis.lonepine.snsapp.presentation.base.DisposableViewModel

class SignInViewModel(private val signInUseCase: SignInUseCase):DisposableViewModel() {

    fun signIn(nickName:String, pwd:String)
    {
        addDisposable(
            signInUseCase.signIn(nickName,pwd)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({

                },{

                })
        )

    }
}