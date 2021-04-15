package jis.lonepine.snsapp.presentation.ui.main

import androidx.lifecycle.LiveData
import jis.lonepine.snsapp.domain.usecase.LoginCheckUseCase
import jis.lonepine.snsapp.domain.usecase.LogOutUseCase
import jis.lonepine.snsapp.presentation.base.DisposableViewModel
import jis.lonepine.snsapp.presentation.base.NotNullMutableLiveData
import jis.lonepine.snsapp.presentation.base.SingleLiveEvent

class MainViewModel(
        private val loginCheckUseCase: LoginCheckUseCase,
        private val logOutUseCase: LogOutUseCase
        ):DisposableViewModel() {

    private val _showSignIn = SingleLiveEvent<Any>()
    val showSignIn:LiveData<Any> = _showSignIn
    fun signInTouched()
    {
        _showSignIn.call()
    }

    private val _showSignUp = SingleLiveEvent<Any>()
    val showSignUp:LiveData<Any> = _showSignUp
    fun signUpTouched()
    {
        _showSignUp.call()
    }

    private val _isLogin = NotNullMutableLiveData(loginCheckUseCase.isLogin())
    val isLogin:LiveData<Boolean> = _isLogin

    fun logoutTouched()
    {
        logOutUseCase.logout()
        checkLogin()
    }

    fun checkLogin()
    {
        _isLogin.value = loginCheckUseCase.isLogin()
    }
}