package jis.lonepine.snsapp.presentation.ui.card

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import jis.lonepine.snsapp.domain.usecase.GetCardDetailUseCase
import jis.lonepine.snsapp.presentation.base.DisposableViewModel

class CardViewModel(private val getCardDetailUseCase: GetCardDetailUseCase):DisposableViewModel() {

    fun load(id:Int)
    {
        addDisposable(
            getCardDetailUseCase.getDetail(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({

                },{

                })
        )
    }
}