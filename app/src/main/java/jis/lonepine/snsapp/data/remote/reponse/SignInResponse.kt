package jis.lonepine.snsapp.data.remote.reponse

data class SignInResponse(
    val ok:Boolean,
    val error_msg:String?,
    val user_id:Int
)
