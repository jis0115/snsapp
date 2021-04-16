package jis.lonepine.snsapp.data.remote.reponse

import jis.lonepine.snsapp.data.entity.User

data class UserInfoResponse(
    val ok:Boolean,
    val msg:String?,
    val user:User
)
