package jis.lonepine.snsapp.data.remote.reponse

data class SignUpResponse(
    val ok:Boolean,
    val error_msg:String?,
    val user_id:Int
)
