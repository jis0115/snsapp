package jis.lonepine.snsapp.data.remote.reponse

import jis.lonepine.snsapp.data.entity.Card
import jis.lonepine.snsapp.data.entity.User

data class CardDetailResponse(
    val ok: Boolean,
    val msg:String?,
    val card: Card,
    val recommend_cards: List<Card>,
    val user: User
)
