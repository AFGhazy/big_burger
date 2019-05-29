package com.template.android.ui.catalog.presenter

import com.template.android.ui.base.presenter.BasePresenter
import com.template.android.ui.base.presenter.BasePresenterImp
import com.template.android.ui.catalog.CatalogContract
import com.template.android.ui.catalog.interactor.CatalogInteractor
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class CatalogPresenter <V: CatalogContract.View, I: CatalogInteractor> @Inject constructor(
    interactor: I,
    compositeDisposable: CompositeDisposable
) :
    BasePresenterImp<V, I>(interactor = interactor, compositeDisposable = compositeDisposable),
    CatalogContract.Presenter<V,I>  {
    override fun loadedSuccessfully() {
        interactor?.let {
            compositeDisposable?.add(it.getBurgers()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .onErrorReturn { e -> emptyList() }
                .subscribe { burgers -> view?.showBurgers(burgers) })
        }
    }

}