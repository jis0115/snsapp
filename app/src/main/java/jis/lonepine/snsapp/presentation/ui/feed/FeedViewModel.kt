package jis.lonepine.snsapp.presentation.ui.feed

import android.util.Log
import androidx.lifecycle.LiveData
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import jis.lonepine.snsapp.data.entity.Card
import jis.lonepine.snsapp.domain.usecase.GetCardListUseCase
import jis.lonepine.snsapp.presentation.base.DisposableViewModel
import jis.lonepine.snsapp.presentation.base.NotNullMutableLiveData
import jis.lonepine.snsapp.presentation.base.SingleLiveEvent
import jis.lonepine.snsapp.presentation.di.ActivityScope
import javax.inject.Inject

@ActivityScope
class FeedViewModel @Inject constructor(private val getCardListUseCase: GetCardListUseCase):DisposableViewModel() {
    private val _feedList = NotNullMutableLiveData(listOf<Card>())
    val feedList:LiveData<List<Card>> = _feedList

    private val _loadFinish = SingleLiveEvent<Any>()
    val loadFinish:LiveData<Any> = _loadFinish

    private var page = 1
    private val per = 20

    fun loadList()
    {
        Log.e("jis","test")
        addDisposable(
            getCardListUseCase.getCardList(page, per)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    Log.e("jis","test >> $it")
                    if (it.ok)
                    {
                        val newList = mutableListOf<Card>()
                        newList.addAll(_feedList.value)
                        newList.addAll(it.cards)
                        _feedList.value = newList
                    }

                },{
                    it.printStackTrace()
                })
        )
    }

    fun reLoadList()
    {
        page = 1
        addDisposable(
            getCardListUseCase.getCardList(page, per)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doFinally {
                    _loadFinish.call()
                }
                .subscribe({
                    if (it.ok)
                    {
                        val newList = mutableListOf<Card>()
                        newList.addAll(it.cards)
                        _feedList.value = newList
                    }
                },{
                    it.printStackTrace()
                })
        )
    }

    private val _showCardInfo = SingleLiveEvent<Int>()
    val showCardInfo:LiveData<Int> = _showCardInfo
    fun cardTouched(cardId:Int)
    {
        _showCardInfo.value = cardId
    }
}