package com.template.android.ui.catalog.presenter

import com.template.android.R
import com.template.android.data.models.Burger
import com.template.android.data.models.BurgerOrder
import com.template.android.ui.base.presenter.BasePresenterImp
import com.template.android.ui.catalog.CatalogContract
import com.template.android.ui.catalog.interactor.CatalogInteractor
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class CatalogPresenter<V : CatalogContract.View, I : CatalogInteractor> @Inject constructor(
    interactor: I,
    compositeDisposable: CompositeDisposable
) :
    BasePresenterImp<V, I>(interactor = interactor, compositeDisposable = compositeDisposable),
    CatalogContract.Presenter<V, I> {

    lateinit var burgers: List<Burger>
    override fun showMyCartClicked() {
        if(::burgers.isInitialized)
            view?.navigateToCart(burgers)
        else view?.navigateToCart(emptyList())
    }

    override fun resetItem(ref: Long) {
        interactor?.let {
            compositeDisposable?.add(it.deleteBurgerOrder(ref)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe{
                    _, e ->
                    e?.let { view?.showMessage(R.string.something_went_wrong) }
                        ?: view?.showMessage(R.string.successful_operation)
                }
            )
        }
    }

    override fun incrementOrder(ref: Long) {
        interactor?.let {
            compositeDisposable?.add(it.getBurgerOrderWithRef(ref)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe { burgerOrders, e ->
                    if(e == null) {
                        val quantity = (if (burgerOrders.isEmpty()) 0 else burgerOrders.first().quantity) + 1
                        insertBurgerOrder(it, ref, quantity)
                    } else view?.showMessage(R.string.something_went_wrong)
                })
        }
    }

    private fun insertBurgerOrder(interactor: I, ref: Long, quantity: Int) =
        interactor.insertBurgerOrder(BurgerOrder(ref, quantity))
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe { l, e ->
                if (e == null) view?.showMessage(R.string.successful_operation)
                else view?.showMessage(R.string.something_went_wrong)
            }

    override fun loadedSuccessfully() {

        interactor?.let {
            compositeDisposable?.add(it.getBurgers()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe { burgers, e ->
                    if(e == null) {
                        this@CatalogPresenter.burgers = burgers
                        view?.showBurgers(burgers)
                    } else view?.showMessage(R.string.something_went_wrong)
                })


        }
    }

    override fun resetAllClicked() {
        interactor?.let {
            compositeDisposable?.add(it
                .deleteAllBurgerOrder()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe {
                    l, e ->
                    if(e == null) view?.showMessage(R.string.successful_operation)
                    else view?.showMessage(R.string.something_went_wrong)
                })
        }
    }

}