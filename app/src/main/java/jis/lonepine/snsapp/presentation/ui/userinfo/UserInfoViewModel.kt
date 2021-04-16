package jis.lonepine.snsapp.presentation.ui.userinfo

import androidx.lifecycle.LiveData
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import jis.lonepine.snsapp.data.entity.User
import jis.lonepine.snsapp.domain.usecase.GetUserInfoUseCase
import jis.lonepine.snsapp.presentation.base.DisposableViewModel
import jis.lonepine.snsapp.presentation.base.SingleLiveEvent
import javax.inject.Inject

class UserInfoViewModel @Inject constructor(private val getUserInfoUseCase: GetUserInfoUseCase):DisposableViewModel() {
    private val _loadFinish = SingleLiveEvent<Any>()
    val loadFinish:LiveData<Any> = _loadFinish

    private val _userInfo = SingleLiveEvent<User>()
    val userInfo:LiveData<User> = _userInfo
    fun getUserInfo(id:Int)
    {
        addDisposable(
            getUserInfoUseCase.getUserInfo(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doFinally {
                    _loadFinish.call()
                }
                .subscribe({
                    if (it.ok)
                    {
                        _userInfo.value = it.user
                    }
                    else if(it.msg?.isNotEmpty() == true)
                    {
                        _showToast.postValue(it.msg)
                    }
                },{
                    it.printStackTrace()
                })
        )
    }
}