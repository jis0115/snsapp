package jis.lonepine.snsapp.domain.usecase

import jis.lonepine.snsapp.domain.repository.UserRepository

class LoginCheckUseCase(private val userRepository: UserRepository) {
    fun isLogin() = userRepository.getUserId()>0
}