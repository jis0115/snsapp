package jis.lonepine.snsapp.domain.usecase

import jis.lonepine.snsapp.domain.repository.HomeRepository
import javax.inject.Inject

class GetHomeUseCase @Inject constructor(private val homeRepository: HomeRepository) {
    fun getHome() = homeRepository.getHomeData()
}