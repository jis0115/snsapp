package jis.lonepine.snsapp.domain.usecase

import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.schedulers.Schedulers
import jis.lonepine.snsapp.data.remote.request.SignUpRequest
import jis.lonepine.snsapp.domain.repository.UserRepository

class SignUpUseCase(private val userRepository: UserRepository) {
    fun signUp(nickName:String, introduction:String,pwd:String,success:()->Unit,fail:(String)->Unit):Disposable{
        return userRepository.signUp(request = SignUpRequest(nickName, introduction, pwd))
                .subscribeOn(Schedulers.io())
                .subscribe({
                    if(it.ok)
                    {
                        userRepository.setUserId(it.user_id)
                        success()
                    }
                    else if (it.error_msg?.isNotEmpty() == true)
                    {
                        fail(it.error_msg)
                    }
                },{

                })


        /*
        .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    if(it.ok)
                    {
                        _signUpSuccess.value = it.user_id
                    }
                    else if (it.error_msg?.isNotEmpty() == true)
                    {
                        _showToast.postValue(it.error_msg)
                    }
                },{
                    it.printStackTrace()
                })
         */
    }
}