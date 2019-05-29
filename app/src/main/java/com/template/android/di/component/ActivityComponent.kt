package com.template.android.di.component

import com.template.android.di.module.ActivityModule
import com.template.android.di.scope.PerActivity
import com.template.android.ui.cart.view.CartFragment
import com.template.android.ui.catalog.view.CatalogFragment
import com.template.android.ui.splash.view.SplashFragment
import dagger.Component

@PerActivity
@Component(dependencies = [ApplicationComponent::class], modules = [ActivityModule::class])
interface ActivityComponent {
    fun inject(fragment: SplashFragment)
    fun inject(fragment: CatalogFragment)
    fun inject(fragment: CartFragment)
}