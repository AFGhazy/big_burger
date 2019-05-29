package com.template.android.ui.base.view

import androidx.fragment.app.Fragment
import com.template.android.di.component.ActivityComponent

abstract class BaseFragment : Fragment() {

    val activityComponent: ActivityComponent?
        get() = (activity as? BaseActivity)?.activityComponent

    abstract fun setUp()
}