package jis.lonepine.snsapp.domain.usecase

import jis.lonepine.snsapp.domain.repository.CardsRepository

class GetCardListUseCase(private val cardsRepository: CardsRepository) {
    fun getCardList(page:Int,per:Int) = cardsRepository.getCardsList(page,per)
}