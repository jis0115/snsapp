package jis.lonepine.snsapp.data.remote.reponse

import jis.lonepine.snsapp.data.entity.Card

data class CardsResponse(
    val ok: Boolean,
    val msg:String?,
    val cards: List<Card>,
)
