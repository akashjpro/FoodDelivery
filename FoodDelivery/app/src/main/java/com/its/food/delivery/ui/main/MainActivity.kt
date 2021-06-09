package com.its.food.delivery.ui.main

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.view.Menu
import android.view.MenuItem
import androidx.activity.viewModels
import androidx.annotation.RequiresApi
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AlertDialog
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.its.food.delivery.R
import com.its.food.delivery.databinding.ActivityMainBinding
import com.its.food.delivery.ui.BaseActivity
import com.its.food.delivery.ui.cart.CartActivity
import com.its.food.delivery.ui.login_and_sign_up.LoginAndSignUpActivity
import com.its.food.delivery.ui.login_and_sign_up.LoginAndSignUpActivityViewModel
import com.its.food.delivery.ui.main.account.AccountFragment
import com.its.food.delivery.ui.main.favorite.FavoriteFragment
import com.its.food.delivery.ui.main.history.HistoryFragment
import com.its.food.delivery.ui.main.home.HomeFragment
import com.its.food.delivery.ui.orders.OrdersActivity
import com.its.food.delivery.util.EMPLOYEE
import com.its.food.delivery.util.api.Resource
import com.its.food.delivery.util.errorDialog
import com.its.food.delivery.util.progressDialog
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*
import kotlinx.coroutines.ExperimentalCoroutinesApi

@RequiresApi(Build.VERSION_CODES.LOLLIPOP)
@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>() {

    // Constants
    companion object {
        private val HOME_SCREEN = HomeFragment()
        private val FAVORITE_SCREEN = FavoriteFragment()
        private val HISTORY_SCREEN = HistoryFragment()
        private val ACCOUNT_SCREEN = AccountFragment()
    }

    private val fragmentManager = supportFragmentManager
    private var activeFragment: Fragment = HOME_SCREEN

    private var progressDialog: AlertDialog? = null

    private val bottomSheetViewModel: BottomSheetViewModel by viewModels()

    // Access view
    private lateinit var toggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Data binding
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.lifecycleOwner = this
        binding.viewModel = this.viewModel
        binding.bottomSheetVM = this.bottomSheetViewModel

        init()
        observe()
        setSupportActionBar(toolbarHome)

        navigateBottomEvent()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.menu_toolbar, menu)

        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.btnCart -> {
                val intent1 = Intent(this@MainActivity, CartActivity::class.java)
                startActivity(intent1)
                true
            }
            android.R.id.home -> {
                drawer_layout.openDrawer(Gravity.LEFT)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun init() {
        viewModel.setHeaderApi()
        //processGetFoods()
        processAlbums()
    }

    private fun observe() {
        viewModel.navigateToLogin.observe(this) { event ->
            event.getContentIfNotHandled().let {
                val intent = Intent(this@MainActivity, LoginAndSignUpActivity::class.java)
                startActivity(intent)
                finish()
                viewModel.saveLogin(false, "", "", "")

            }
        }
        viewModel.navigateToOrder.observe(this) { event ->
            event.getContentIfNotHandled().let {
                val intent = Intent(this@MainActivity, OrdersActivity::class.java)
                startActivity(intent)
            }
        }
    }

    private fun navigateBottomEvent() {
        fragmentManager.beginTransaction().apply {
            add(R.id.container, HISTORY_SCREEN, "History").hide(
                HISTORY_SCREEN
            )
            add(R.id.container, ACCOUNT_SCREEN, "Account").hide(
                ACCOUNT_SCREEN
            )
            add(R.id.container, FAVORITE_SCREEN, "Favorite").hide(
                FAVORITE_SCREEN
            )
            add(R.id.container, HOME_SCREEN, getString(R.string.title_home))
        }.commit()

        nav_view.setOnNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.navigation_home -> {
                    fragmentManager.beginTransaction().hide(activeFragment).show(HOME_SCREEN)
                        .commit()
                    activeFragment = HOME_SCREEN
                    true
                }
                R.id.navigation_favorite -> {
                    fragmentManager.beginTransaction().hide(activeFragment)
                        .show(FAVORITE_SCREEN)
                        .commit()
                    activeFragment = FAVORITE_SCREEN
                    true
                }
                R.id.navigation_account -> {
                    fragmentManager.beginTransaction().hide(activeFragment).show(ACCOUNT_SCREEN)
                        .commit()
                    activeFragment = ACCOUNT_SCREEN
                    true
                }
                R.id.navigation_history -> {
                    fragmentManager.beginTransaction().hide(activeFragment).show(HISTORY_SCREEN)
                        .commit()
                    activeFragment = HISTORY_SCREEN
                    true
                }

                else -> false
            }
        }
    }

    private fun processGetFoods() {
        progressDialog = progressDialog(this, getString(R.string.logging_msg))

        viewModel.getFoods().observe(this) { resource ->

            when(resource){
                is Resource.Loading -> {
                    progressDialog?.show()
                }
                is Resource.Error -> {
                    progressDialog?.dismiss()
                }
                is Resource.Success -> {
                    progressDialog?.dismiss()

                    val result = resource.data.result

                    if (result) {
                        val foods = resource.data?.data

                        viewModel.setFoods(foods)
                    }
                }
            }
        }
    }

    private fun processAlbums() {
        progressDialog = progressDialog(this, getString(R.string.logging_msg))

        viewModel.getAlbums().observe(this) { resource ->

            when(resource){
                is Resource.Loading -> {
                    progressDialog?.show()
                    Log.d("TAG_MAIN", "Resource.Loading: ")
                }
                is Resource.Error -> {
                    progressDialog?.dismiss()
                    Log.d("TAG_MAIN", "Resource.Error resource.code: ${resource.code} ")
                }
                is Resource.Success -> {
                    progressDialog?.dismiss()

                    Log.d("TAG_MAIN", "Resource.Success resource.data: ${resource.data.toString()} ")

                }
            }
        }
    }
}