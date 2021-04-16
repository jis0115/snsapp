package jis.lonepine.snsapp.presentation.ui.home.model

import jis.lonepine.snsapp.data.entity.Card
import jis.lonepine.snsapp.data.entity.User

sealed class HomeUIModel
{
    class CardUIModel(val cardList:List<Card>):HomeUIModel()
    class UserUIModel(val userList:List<User>):HomeUIModel()
}
