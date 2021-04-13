package jis.lonepine.snsapp.domain.usecase

import jis.lonepine.snsapp.data.remote.request.SignUpRequest
import jis.lonepine.snsapp.domain.repository.UserRepository

class SignUpUseCase(private val userRepository: UserRepository) {
    fun signUp(nickName:String, introduction:String,pwd:String) = userRepository.signUp(request = SignUpRequest(nickName, introduction, pwd))
}