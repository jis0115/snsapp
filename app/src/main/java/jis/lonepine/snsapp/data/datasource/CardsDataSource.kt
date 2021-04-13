package jis.lonepine.snsapp.data.datasource

import io.reactivex.rxjava3.core.Single
import jis.lonepine.snsapp.data.remote.reponse.CardDetailResponse
import jis.lonepine.snsapp.data.remote.reponse.CardsResponse

interface CardsDataSource {
    fun getCardsList(page:Int,per:Int):Single<CardsResponse>
    fun getCardDetail(id:Int):Single<CardDetailResponse>
}