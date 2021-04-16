package jis.lonepine.snsapp.domain.repository

import io.reactivex.rxjava3.core.Single
import jis.lonepine.snsapp.data.datasource.UserDataSource
import jis.lonepine.snsapp.data.local.Storage
import jis.lonepine.snsapp.data.remote.SnsAppApi
import jis.lonepine.snsapp.data.remote.reponse.SignInResponse
import jis.lonepine.snsapp.data.remote.reponse.SignUpResponse
import jis.lonepine.snsapp.data.remote.reponse.UserInfoResponse
import jis.lonepine.snsapp.data.remote.request.SignInRequest
import jis.lonepine.snsapp.data.remote.request.SignUpRequest
import javax.inject.Inject

class UserRepository @Inject constructor(private val api:SnsAppApi, private val storage: Storage):UserDataSource {
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
        return storage.getUserId()
    }

    override fun setUserId(id: Int) {
        storage.setUserId(id)
    }
}