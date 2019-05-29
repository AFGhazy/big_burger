package com.template.android.di.component

import com.template.android.BaseApp
import com.template.android.data.database.DBHelper
import com.template.android.data.network.ApiHelper
import com.template.android.di.module.ApplicationModule
import dagger.Component
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Singleton

@Singleton
@Component(modules = [ApplicationModule::class])
interface ApplicationComponent {
    fun inject(application: BaseApp)
    fun exposeCompositeDisposable(): CompositeDisposable
    fun exposeDbHelper(): DBHelper
    fun exposeApiHelper(): ApiHelper
}