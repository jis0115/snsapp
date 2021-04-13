package jis.lonepine.snsapp.presentation.ui.home

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import jis.lonepine.snsapp.domain.usecase.GetHomeUseCase
import jis.lonepine.snsapp.presentation.base.DisposableViewModel

class HomeViewModel(private val getHomeUseCase: GetHomeUseCase):DisposableViewModel() {



    fun loadHomeData()
    {
        addDisposable(
                getHomeUseCase.getHome()
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe({
                           if (it.ok)
                           {

                           }
                            else
                           {

                           }
                        },{
                            it.printStackTrace()
                        })
        )
    }
}