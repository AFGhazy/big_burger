package com.template.android.ui.cart.presenter

import com.template.android.data.models.Burger
import com.template.android.ui.base.interactor.BaseInteractor
import com.template.android.ui.base.presenter.BasePresenterImp
import com.template.android.ui.base.view.BaseViewContract
import com.template.android.ui.cart.CartContract
import com.template.android.ui.cart.interactor.CartInteractor
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class CartPresenter<V: CartContract.View, I: CartInteractor> @Inject constructor(interactor: I, compositeDisposable: CompositeDisposable) : CartContract.Presenter<V, I>,
    BasePresenterImp<V, I>(interactor, compositeDisposable) {
    override fun loadedSuccessfully(burgers: List<Burger>) {
        val burgersData = HashMap<Long, Burger>().apply {
            for(burger in burgers) this[burger.reference] = burger
        }

        interactor?.let {
            compositeDisposable?.add(
                it.getAllBurgerOrders()
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe { orders, e ->
                        val burgersWithQuantities = ArrayList<BurgerWithQuantity>()
                        var sum = 0L
                        for(order in orders) {
                            burgersData[order.id]?.let {
                                burgersWithQuantities.add(BurgerWithQuantity(it, order.quantity))
                                sum += order.quantity * it.price
                            }
                        }
                        view?.showBurgersWithQuantities(burgersWithQuantities)
                        view?.showTotalPrice(sum)
                    }
            )
        }
    }

    companion object {
        data class BurgerWithQuantity(
            val burger: Burger,
            val quantity: Int
        )
    }
}