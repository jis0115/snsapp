package jis.lonepine.snsapp.domain.usecase

import jis.lonepine.snsapp.domain.repository.CardsRepository
import javax.inject.Inject

class GetCardDetailUseCase @Inject constructor(private val cardsRepository: CardsRepository) {
    fun getDetail(id:Int) = cardsRepository.getCardDetail(id)
}