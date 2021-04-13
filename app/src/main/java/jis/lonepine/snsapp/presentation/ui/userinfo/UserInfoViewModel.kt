package jis.lonepine.snsapp.presentation.ui.userinfo

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import jis.lonepine.snsapp.domain.usecase.GetUserInfoUseCase
import jis.lonepine.snsapp.presentation.base.DisposableViewModel

class UserInfoViewModel(private val getUserInfoUseCase: GetUserInfoUseCase):DisposableViewModel() {
    fun getUserInfo(id:Int)
    {
        addDisposable(
            getUserInfoUseCase.getUserInfo(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({

                },{
                    it.printStackTrace()
                })
        )
    }
}