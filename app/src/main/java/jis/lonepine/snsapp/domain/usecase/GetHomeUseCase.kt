package jis.lonepine.snsapp.domain.usecase

import jis.lonepine.snsapp.domain.repository.HomeRepository

class GetHomeUseCase(private val homeRepository: HomeRepository) {
    fun getHome() = homeRepository.getHomeData()
}