package jis.lonepine.snsapp.domain.usecase

import jis.lonepine.snsapp.domain.repository.UserRepository
import javax.inject.Inject

class LoginCheckUseCase @Inject constructor(private val userRepository: UserRepository) {
    fun isLogin() = userRepository.getUserId()>0
}