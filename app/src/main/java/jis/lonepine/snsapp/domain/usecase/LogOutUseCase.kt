package jis.lonepine.snsapp.domain.usecase

import jis.lonepine.snsapp.domain.repository.UserRepository
import javax.inject.Inject

class LogOutUseCase @Inject constructor(private val userRepository: UserRepository) {
    fun logout() = userRepository.setUserId(0)
}