package jis.lonepine.snsapp.data.remote.reponse

import jis.lonepine.snsapp.data.entity.Card
import jis.lonepine.snsapp.data.entity.User

data class HomeResponse(
    val ok: Boolean,
    val msg:String?,
    val popular_cards: List<Card>,
    val popular_users: List<User>
)