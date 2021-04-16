package jis.lonepine.snsapp.data.datasource

import io.reactivex.rxjava3.core.Single
import jis.lonepine.snsapp.data.remote.reponse.SignInResponse
import jis.lonepine.snsapp.data.remote.reponse.SignUpResponse
import jis.lonepine.snsapp.data.remote.reponse.UserInfoResponse
import jis.lonepine.snsapp.data.remote.request.SignInRequest
import jis.lonepine.snsapp.data.remote.request.SignUpRequest

interface UserDataSource {
    fun signUp(request:SignUpRequest):Single<SignUpResponse>
    fun signIn(request:SignInRequest):Single<SignInResponse>
    fun getUserInfo(id:Int):Single<UserInfoResponse>
    fun getUserId():Int
    fun setUserId(id:Int)
}