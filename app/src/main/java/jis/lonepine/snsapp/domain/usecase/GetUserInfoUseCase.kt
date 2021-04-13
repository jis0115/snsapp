package jis.lonepine.snsapp.domain.usecase

import jis.lonepine.snsapp.domain.repository.UserRepository

class GetUserInfoUseCase(private val userRepository: UserRepository) {
    fun getUserInfo(id:Int) = userRepository.getUserInfo(id)
}