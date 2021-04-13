package jis.lonepine.snsapp.presentation.ui.feed

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import jis.lonepine.snsapp.domain.usecase.GetCardListUseCase
import jis.lonepine.snsapp.presentation.base.DisposableViewModel

class FeedViewModel(private val getCardListUseCase: GetCardListUseCase):DisposableViewModel() {
    private var page = 1
    private val per = 20

    fun loadList()
    {
        addDisposable(
            getCardListUseCase.getCardList(page, per)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({

                },{

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
                .subscribe({

                },{

                })
        )
    }
}