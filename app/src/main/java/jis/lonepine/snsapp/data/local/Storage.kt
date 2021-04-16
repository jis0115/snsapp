package jis.lonepine.snsapp.data.local

interface Storage {
    fun setUserId(value: Int)
    fun getUserId(): Int
}