package com.template.android.ui.catalog.view

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.template.android.R
import com.template.android.data.models.Burger
import com.template.android.ui.base.view.BaseFragment
import com.template.android.ui.catalog.CatalogContract
import com.template.android.ui.catalog.interactor.CatalogInteractor
import com.template.android.ui.catalog.presenter.CatalogPresenter
import com.template.android.ui.catalog.recycler.BurgerAdapter
import kotlinx.android.synthetic.main.fragment_catalog.*
import javax.inject.Inject


class CatalogFragment  : BaseFragment(), CatalogContract.View {
    @Inject
    internal lateinit var presenter: CatalogPresenter<CatalogContract.View, CatalogInteractor>

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View =
        inflater.inflate(R.layout.fragment_catalog, container, false)

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

    override fun showBurgers(burgers: List<Burger>) {
        burgersRv.layoutManager = LinearLayoutManager(activity)
        burgersRv.adapter = BurgerAdapter(burgers)
    }

    private fun setUpDI() {
        activityComponent?.inject(this)
    }

    companion object {
        fun newInstance() = CatalogFragment()
    }
}