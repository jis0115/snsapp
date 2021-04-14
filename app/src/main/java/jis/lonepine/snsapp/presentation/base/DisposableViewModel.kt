package jis.lonepine.snsapp.presentation.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.disposables.Disposable

open class DisposableViewModel: ViewModel() {
    private val compositeDisposable = CompositeDisposable()

    fun addDisposable(disposable: Disposable) {
        compositeDisposable.add(disposable)
    }

    override fun onCleared() {
        compositeDisposable.clear()
        super.onCleared()
    }

    fun clearDisposable()
    {
        compositeDisposable.clear()
    }

    val _showToast = SingleLiveEvent<String>()
    val showToast:LiveData<String> = _showToast
}