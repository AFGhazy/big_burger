package com.template.android.ui.catalog.view

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.template.android.R
import com.template.android.data.models.Burger
import com.template.android.ui.base.view.BaseFragment
import com.template.android.ui.cart.view.CartActivity
import com.template.android.ui.cart.view.CartActivity.Companion.BURGER_LIST
import com.template.android.ui.catalog.CatalogContract
import com.template.android.ui.catalog.interactor.CatalogInteractor
import com.template.android.ui.catalog.presenter.CatalogPresenter
import com.template.android.ui.catalog.recycler.BurgerAdapter
import kotlinx.android.synthetic.main.fragment_catalog.*
import javax.inject.Inject


class CatalogFragment  : BaseFragment(), CatalogContract.View {
    override fun navigateToCart(burgers: List<Burger>) {
        startActivity(Intent(activity, CartActivity::class.java).apply {
            putExtras(Bundle().apply {
                putParcelableArrayList(BURGER_LIST, ArrayList(burgers))
            })
        })
    }

    @Inject
    internal lateinit var presenter: CatalogPresenter<CatalogContract.View, CatalogInteractor>

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View =
        inflater.inflate(R.layout.fragment_catalog, container, false)

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        setUp()
        presenter.loadedSuccessfully()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        showMyCartBtn.setOnClickListener {
            presenter.showMyCartClicked()
        }
        resetAll.setOnClickListener {
            presenter.resetAllClicked()
        }
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
        burgersRv.adapter = BurgerAdapter(burgers, presenter)
    }

    private fun setUpDI() {
        activityComponent?.inject(this)
    }

    companion object {
        fun newInstance() = CatalogFragment()
    }
}