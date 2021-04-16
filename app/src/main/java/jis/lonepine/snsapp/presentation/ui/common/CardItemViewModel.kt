package jis.lonepine.snsapp.presentation.ui.common

import androidx.lifecycle.LiveData
import jis.lonepine.snsapp.presentation.base.DisposableViewModel
import jis.lonepine.snsapp.presentation.base.SingleLiveEvent
import javax.inject.Inject


class CardItemViewModel @Inject constructor() :DisposableViewModel() {

    private val _showCardInfo = SingleLiveEvent<Int>()
    val showCardInfo: LiveData<Int> = _showCardInfo
    fun cardTouched(cardId:Int)
    {
        _showCardInfo.value = cardId
    }
}