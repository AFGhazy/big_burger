package com.template.android.ui.base.view

import android.widget.Toast
import androidx.fragment.app.Fragment
import com.template.android.di.component.ActivityComponent

abstract class BaseFragment : Fragment(), BaseViewContract {

    val activityComponent: ActivityComponent?
        get() = (activity as? BaseActivity)?.activityComponent

    abstract fun setUp()

    override fun showMessage(res: Int) {
        Toast.makeText(activity, res, Toast.LENGTH_LONG).show()
    }
}