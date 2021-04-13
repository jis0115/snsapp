package jis.lonepine.snsapp.data.remote

import io.reactivex.rxjava3.core.Single
import jis.lonepine.snsapp.data.remote.reponse.*
import jis.lonepine.snsapp.data.remote.request.SignInRequest
import jis.lonepine.snsapp.data.remote.request.SignUpRequest
import retrofit2.http.*

interface SnsAppApi {
    @GET("/home")
    fun getHome(): Single<HomeResponse>

    @GET("/cards")
    fun getCardList(
        @Query("page") page: Int,
        @Query("per") per: Int
    ): Single<CardsResponse>

    @GET("/cards/{id}")
    fun getCardDetail(@Path("id") id: Int): Single<CardDetailResponse>

    @POST("/users")
    fun signUp(@Body request: SignUpRequest): Single<SignUpResponse>

    @POST("/users/sign_in")
    fun signIn(@Body request: SignInRequest): Single<SignInResponse>

    @GET("/users/{id}")
    fun getUserInfo(@Path("id") id: Int): Single<UserInfoResponse>
//

}