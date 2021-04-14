package jis.lonepine.snsapp.presentation.ui.main

import androidx.lifecycle.LiveData
import jis.lonepine.snsapp.presentation.base.DisposableViewModel
import jis.lonepine.snsapp.presentation.base.SingleLiveEvent

class MainViewModel:DisposableViewModel() {

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
}