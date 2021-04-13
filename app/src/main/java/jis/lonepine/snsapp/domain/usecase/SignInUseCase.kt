package jis.lonepine.snsapp.domain.usecase

import jis.lonepine.snsapp.data.remote.request.SignInRequest
import jis.lonepine.snsapp.domain.repository.UserRepository

class SignInUseCase(private val userRepository: UserRepository) {
    fun signIn(nickname:String, pwd:String) = userRepository.signIn(SignInRequest(nickname, pwd))
}