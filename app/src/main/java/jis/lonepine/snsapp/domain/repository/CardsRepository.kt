package jis.lonepine.snsapp.domain.repository

import io.reactivex.rxjava3.core.Single
import jis.lonepine.snsapp.data.datasource.CardsDataSource
import jis.lonepine.snsapp.data.remote.reponse.CardDetailResponse
import jis.lonepine.snsapp.data.remote.reponse.CardsResponse
import jis.lonepine.snsapp.data.remote.SnsAppApi
import javax.inject.Inject

class CardsRepository @Inject constructor(private val api:SnsAppApi):CardsDataSource {
    override fun getCardsList(page: Int, per: Int): Single<CardsResponse> {
        return api.getCardList(page, per)
    }

    override fun getCardDetail(id: Int): Single<CardDetailResponse> {
        return api.getCardDetail(id)
    }
}