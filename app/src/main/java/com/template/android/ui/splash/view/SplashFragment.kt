package com.template.android.ui.splash.view

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.template.android.R
import com.template.android.ui.base.view.BaseFragment
import com.template.android.ui.catalog.view.CatalogActivity
import com.template.android.ui.splash.SplashContract
import com.template.android.ui.splash.interactor.SplashInteractor
import com.template.android.ui.splash.presenter.SplashPresenter
import javax.inject.Inject

class SplashFragment : BaseFragment(), SplashContract.View {
    override fun navigateToCatalog() {
        startActivity(Intent(context, CatalogActivity::class.java))
    }

    @Inject
    internal lateinit var presenter: SplashPresenter<SplashContract.View, SplashInteractor>

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View =
        inflater.inflate(R.layout.fragment_splash, container, false)

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        setUp()
        presenter.loadedSuccessfully()
    }

    override fun setUp() {
        setUpDI()
        presenter.attachView(this)
    }

    override fun onDestroy() {
        presenter.dropView()
        super.onDestroy()
    }

    private fun setUpDI() {
        activityComponent?.inject(this)
    }

    companion object {
        fun newInstance() = SplashFragment()
    }
}