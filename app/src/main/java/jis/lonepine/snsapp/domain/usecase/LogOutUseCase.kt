package jis.lonepine.snsapp.domain.usecase

import jis.lonepine.snsapp.domain.repository.UserRepository

class LogOutUseCase(private val userRepository: UserRepository) {
    fun logout() = userRepository.setUserId(0)
}