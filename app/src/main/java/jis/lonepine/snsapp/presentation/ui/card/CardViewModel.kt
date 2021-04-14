package jis.lonepine.snsapp.presentation.ui.card

import androidx.lifecycle.LiveData
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import jis.lonepine.snsapp.data.entity.User
import jis.lonepine.snsapp.domain.usecase.GetCardDetailUseCase
import jis.lonepine.snsapp.presentation.base.DisposableViewModel
import jis.lonepine.snsapp.presentation.base.SingleLiveEvent

class CardViewModel(private val getCardDetailUseCase: GetCardDetailUseCase):DisposableViewModel() {

    private val _cardImageUrl = SingleLiveEvent<String>()
    val cardImageUrl:LiveData<String> = _cardImageUrl

    private val _cardDescription = SingleLiveEvent<String>()
    val cardDescription:LiveData<String> = _cardDescription

    private val _loadFinish = SingleLiveEvent<Any>()
    val loadFinish:LiveData<Any> = _loadFinish

    private val _writerInfo = SingleLiveEvent<User>()
    val writerInfo:LiveData<User> = _writerInfo
    fun load(id:Int)
    {
        addDisposable(
            getCardDetailUseCase.getDetail(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doFinally {
                    _loadFinish.call()
                }
                .subscribe({
                    if (it.ok)
                    {
                        _cardImageUrl.value = it.card.img_url
                        _cardDescription.value = it.card.description

                        _writerInfo.value = it.user
                    }
                    else if(it.msg?.isNotEmpty() == true)
                    {
                        _showToast.postValue(it.msg)
                    }
                },{

                })
        )
    }

    private val _showUserInfo = SingleLiveEvent<Int>()
    val showUserInfo:LiveData<Int> = _showUserInfo
    fun userInfoTouched(userId:Int)
    {
        _showUserInfo.value = userId
    }
}