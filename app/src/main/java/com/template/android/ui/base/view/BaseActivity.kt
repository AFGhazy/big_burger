package com.template.android.ui.base.view

import androidx.appcompat.app.AppCompatActivity
import com.template.android.BaseApp
import com.template.android.di.component.ActivityComponent
import com.template.android.di.component.DaggerActivityComponent
import com.template.android.di.module.ActivityModule

abstract class BaseActivity : AppCompatActivity() {
    var activityComponent: ActivityComponent? = null
        private set

    fun setUpDi() {

        activityComponent = DaggerActivityComponent.builder()
            .applicationComponent((application as? BaseApp)?.applicationComponent)
            .activityModule(ActivityModule(this)).build()
    }
}