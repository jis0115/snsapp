package jis.lonepine.snsapp.presentation.ui.signin

import androidx.lifecycle.LiveData
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import jis.lonepine.snsapp.domain.usecase.SignInUseCase
import jis.lonepine.snsapp.presentation.base.DisposableViewModel
import jis.lonepine.snsapp.presentation.base.SingleLiveEvent

class SignInViewModel(private val signInUseCase: SignInUseCase):DisposableViewModel() {


    private val _signInSuccess = SingleLiveEvent<Int>()
    val signInSuccess:LiveData<Int> = _signInSuccess
    fun signIn(nickName:String, pwd:String)
    {
        addDisposable(
            signInUseCase.signIn(nickName,pwd)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    if (it.ok)
                    {
                        _signInSuccess.value = it.user_id
                    }
                    else if (it.error_msg?.isNotEmpty() == true)
                    {
                        _showToast.postValue(it.error_msg)
                    }
                },{

                })
        )

    }
}