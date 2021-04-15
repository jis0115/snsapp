package jis.lonepine.snsapp.domain.usecase

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.schedulers.Schedulers
import jis.lonepine.snsapp.data.remote.request.SignInRequest
import jis.lonepine.snsapp.domain.repository.UserRepository

class SignInUseCase(private val userRepository: UserRepository) {
    fun signIn(nickname:String, pwd:String,success:(Int)->Unit, fail:(String)->Unit):Disposable
    {
        return userRepository.signIn(SignInRequest(nickname, pwd))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    if (it.ok) {
                        it.user_id.let {userId->
                            userRepository.setUserId(userId)
                            success(userId)
                        }
                    } else if (it.error_msg?.isNotEmpty() == true) {
                        fail(it.error_msg)
                    }
                }, {

                })
    }
}