package jis.lonepine.snsapp.data.local

import android.content.Context
import javax.inject.Inject

class SharedPreferencesStorage @Inject constructor(context: Context):Storage {
    private val sharedPreferences = context.getSharedPreferences(context.packageName, Context.MODE_PRIVATE)
    init {
        setUserId(0)
    }
    override fun setUserId(value: Int) {
        with(sharedPreferences.edit()) {
            putInt("userId", value)
            apply()
        }
    }
    override fun getUserId(): Int {
        return sharedPreferences.getInt("userId", 0)
    }
}