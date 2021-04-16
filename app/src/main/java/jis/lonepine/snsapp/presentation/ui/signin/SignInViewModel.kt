package jis.lonepine.snsapp.presentation.ui.signin

import androidx.lifecycle.LiveData
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import jis.lonepine.snsapp.domain.usecase.SignInUseCase
import jis.lonepine.snsapp.presentation.base.DisposableViewModel
import jis.lonepine.snsapp.presentation.base.SingleLiveEvent
import jis.lonepine.snsapp.presentation.di.ActivityScope
import javax.inject.Inject

@ActivityScope
class SignInViewModel @Inject constructor(private val signInUseCase: SignInUseCase):DisposableViewModel() {
    private val _signInSuccess = SingleLiveEvent<Int>()
    val signInSuccess:LiveData<Int> = _signInSuccess
    fun signIn(nickName:String, pwd:String)
    {
        addDisposable(
            signInUseCase.signIn(
                    nickName,
                    pwd,
                    success = {
                        _signInSuccess.value = it
                    },
                    fail={
                        _showToast.postValue(it)
                    }
            )
        )
    }
}