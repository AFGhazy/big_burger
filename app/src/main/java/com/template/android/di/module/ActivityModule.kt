package com.template.android.di.module

import com.template.android.di.scope.PerActivity
import com.template.android.ui.base.view.BaseActivity
import com.template.android.ui.cart.CartContract
import com.template.android.ui.cart.interactor.CartInteractor
import com.template.android.ui.cart.interactor.CartInteractorImp
import com.template.android.ui.cart.presenter.CartPresenter
import com.template.android.ui.catalog.CatalogContract
import com.template.android.ui.catalog.interactor.CatalogInteractor
import com.template.android.ui.catalog.interactor.CatalogInteractorImp
import com.template.android.ui.catalog.presenter.CatalogPresenter
import com.template.android.ui.splash.SplashContract
import com.template.android.ui.splash.interactor.SplashInteractor
import com.template.android.ui.splash.interactor.SplashInteractorImp
import com.template.android.ui.splash.presenter.SplashPresenter
import dagger.Module
import dagger.Provides

@Module
class ActivityModule(private val activity: BaseActivity) {
    @Provides
    @PerActivity
    internal fun provideSplashScreenInteractor(interactor: SplashInteractorImp): SplashInteractor = interactor

    @Provides
    @PerActivity
    internal fun provideSplashScreenPresenter(
        presenter: SplashPresenter<SplashContract.View, SplashInteractor>
    ): SplashContract.Presenter<SplashContract.View, SplashInteractor> = presenter

    @Provides
    @PerActivity
    internal fun provideCatalogInteractor(interactor: CatalogInteractorImp) : CatalogInteractor = interactor

    @Provides
    @PerActivity
    internal fun provideCatalogPresenter (
        presenter: CatalogPresenter<CatalogContract.View, CatalogInteractor>
    ): CatalogContract.Presenter<CatalogContract.View, CatalogInteractor> = presenter

    @Provides
    @PerActivity
    internal fun provideCartInteractor(interactor: CartInteractorImp) : CartInteractor = interactor

    @Provides
    @PerActivity
    internal fun provideCartPresenter (
        presenter: CartPresenter<CartContract.View, CartInteractor>
    ): CartContract.Presenter<CartContract.View, CartInteractor> = presenter
}