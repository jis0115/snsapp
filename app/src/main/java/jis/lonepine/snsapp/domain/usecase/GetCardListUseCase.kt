package jis.lonepine.snsapp.domain.usecase

import jis.lonepine.snsapp.domain.repository.CardsRepository
import javax.inject.Inject

class GetCardListUseCase @Inject constructor(private val cardsRepository: CardsRepository) {
    fun getCardList(page:Int,per:Int) = cardsRepository.getCardsList(page,per)
}