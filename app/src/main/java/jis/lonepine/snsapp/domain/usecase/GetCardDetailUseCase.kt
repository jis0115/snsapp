package jis.lonepine.snsapp.domain.usecase

import jis.lonepine.snsapp.domain.repository.CardsRepository

class GetCardDetailUseCase(private val cardsRepository: CardsRepository) {
    fun getDetail(id:Int) = cardsRepository.getCardDetail(id)
}