package jis.lonepine.snsapp.domain.repository

import io.reactivex.rxjava3.core.Single
import jis.lonepine.snsapp.data.datasource.UserDataSource
import jis.lonepine.snsapp.data.local.LoginUser
import jis.lonepine.snsapp.data.remote.SnsAppApi
import jis.lonepine.snsapp.data.remote.reponse.SignInResponse
import jis.lonepine.snsapp.data.remote.reponse.SignUpResponse
import jis.lonepine.snsapp.data.remote.reponse.UserInfoResponse
import jis.lonepine.snsapp.data.remote.request.SignInRequest
import jis.lonepine.snsapp.data.remote.request.SignUpRequest

class UserRepository(private val api:SnsAppApi):UserDataSource {
    override fun signUp(request: SignUpRequest): Single<SignUpResponse> {
        return api.signUp(request)
    }

    override fun signIn(request: SignInRequest): Single<SignInResponse> {
        return api.signIn(request)
    }

    override fun getUserInfo(id: Int): Single<UserInfoResponse> {
        return api.getUserInfo(id)
    }

    override fun getUserId(): Int {
        return LoginUser.userId
    }

    override fun setUserId(id: Int) {
        LoginUser.userId = id
    }
}