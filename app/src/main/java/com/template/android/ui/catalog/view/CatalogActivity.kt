package com.template.android.ui.catalog.view

import android.os.Bundle
import com.template.android.R
import com.template.android.ui.base.view.BaseActivity
import com.template.android.util.extension.addFragment

class CatalogActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setUpDi()
        setContentView(R.layout.activity_catalog)
        addFragment(CatalogFragment.newInstance(), R.id.fragment_container)
    }

}