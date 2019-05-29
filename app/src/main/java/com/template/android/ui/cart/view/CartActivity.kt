package com.template.android.ui.cart.view

import android.os.Bundle
import com.template.android.R
import com.template.android.data.models.Burger
import com.template.android.ui.base.view.BaseActivity
import com.template.android.util.extension.addFragment
import com.template.android.util.extension.withArgs

class CartActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setUpDi()
        setContentView(R.layout.activity_cart)

        addFragment(CartFragment.newInstance().withArgs {
            putParcelableArrayList(BURGER_LIST, intent?.extras?.getParcelableArrayList<Burger>(BURGER_LIST))
        }, R.id.fragment_container)
    }

    companion object {
        const val BURGER_LIST = "BURGER_LIST"
    }

}