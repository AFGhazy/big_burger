package com.template.android.di.module

import android.app.Application
import android.content.SharedPreferences
import android.preference.PreferenceManager
import com.template.android.BuildConfig
import com.template.android.R
import com.template.android.data.database.DBHelper
import com.template.android.data.database.DBHelperImp
import com.template.android.data.network.ApiHelper
import com.template.android.data.network.ApiHelperImp
import com.template.android.data.network.BurgerService
import com.template.android.di.scope.PerApplication
import com.template.android.util.Constants.Companion.RETRO_CACHE_CHILD
import com.template.android.util.Constants.Companion.RETRO_CACHE_SIZE
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable
import okhttp3.Cache
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.io.File
import javax.inject.Singleton

@Module
class ApplicationModule(private val application: Application) {
    @Provides
    @Singleton
    internal fun provideSharedPrefernces(): SharedPreferences {
        return PreferenceManager.getDefaultSharedPreferences(application)
    }

    @Provides
    internal fun provideCompositeDisposable(): CompositeDisposable = CompositeDisposable()

    @Provides
    @Singleton
    @PerApplication
    fun provideApplication(): Application {
        return application
    }

    @Provides
    @Singleton
    fun provideDbHelper(dbHelperImp: DBHelperImp): DBHelper = dbHelperImp

    @Provides
    @Singleton
    fun provideApiHelper(apiHelperImp: ApiHelperImp): ApiHelper = apiHelperImp

    @Provides
    @Singleton
    fun provideRetroCache(): Cache =
        Cache(File(application.cacheDir, RETRO_CACHE_CHILD), RETRO_CACHE_SIZE)

    @Provides
    @Singleton
    fun provideRetroClient(cache: Cache) = OkHttpClient().newBuilder()
        .cache(cache)
        .build()

    @Provides
    @Singleton
    fun provideBurgerService(okHttpClient: OkHttpClient): BurgerService = Retrofit.Builder()
        .baseUrl(BuildConfig.BASE_URL)
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build().create(BurgerService::class.java)
}