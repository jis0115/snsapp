package jis.lonepine.snsapp.presentation.ui.common

import androidx.lifecycle.LiveData
import jis.lonepine.snsapp.presentation.base.DisposableViewModel
import jis.lonepine.snsapp.presentation.base.SingleLiveEvent

class UserItemViewModel:DisposableViewModel() {
    private val _showUserInfo = SingleLiveEvent<Int>()
    val showUserInfo: LiveData<Int> = _showUserInfo
    fun userInfoTouched(userId:Int)
    {
        _showUserInfo.value = userId
    }
}