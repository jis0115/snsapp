package jis.lonepine.snsapp.presentation.ui.home

import androidx.lifecycle.LiveData
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import jis.lonepine.snsapp.domain.usecase.GetHomeUseCase
import jis.lonepine.snsapp.presentation.base.DisposableViewModel
import jis.lonepine.snsapp.presentation.base.NotNullMutableLiveData
import jis.lonepine.snsapp.presentation.base.SingleLiveEvent
import jis.lonepine.snsapp.presentation.ui.home.model.HomeUIModel

class HomeViewModel(private val getHomeUseCase: GetHomeUseCase):DisposableViewModel() {
    private val _homeItems = NotNullMutableLiveData(listOf<HomeUIModel>())
    val homeItems:LiveData<List<HomeUIModel>> = _homeItems

    private val _loadFinish = SingleLiveEvent<Any>()
    val loadFinish:LiveData<Any> = _loadFinish
    fun loadHomeData()
    {
        addDisposable(
            getHomeUseCase.getHome()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doFinally { _loadFinish.call() }
                .subscribe({
                   if (it.ok)
                   {
                       _homeItems.value = mutableListOf<HomeUIModel>().apply {
                           add(HomeUIModel.CardUIModel(it.popular_cards))
                           add(HomeUIModel.UserUIModel(it.popular_users))
                       }
                   }
                   else if (it.msg?.isNotEmpty() == true)
                   {
                       _showToast.postValue(it.msg)
                   }
                },{
                    it.printStackTrace()
                })
)
    }
}