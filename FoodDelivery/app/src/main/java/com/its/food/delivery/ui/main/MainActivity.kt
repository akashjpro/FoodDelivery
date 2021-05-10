package com.its.food.delivery.ui.main

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.its.food.delivery.R
import com.its.food.delivery.databinding.ActivityMainBinding
import com.its.food.delivery.ui.BaseActivity
import com.its.food.delivery.ui.cart.CartActivity
import com.its.food.delivery.ui.main.account.AccountFragment
import com.its.food.delivery.ui.main.favorite.FavoriteFragment
import com.its.food.delivery.ui.main.history.HistoryFragment
import com.its.food.delivery.ui.main.home.Food
import com.its.food.delivery.ui.main.home.HomeFragment
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*

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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Data binding
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.lifecycleOwner = this
        binding.viewModel = this.viewModel

        setSupportActionBar(toolbarHome)

        navigateBottomEvent()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.menu_toolbar, menu)

        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId) {
            R.id.btnCart -> {
                val intent1 = Intent(this@MainActivity, CartActivity::class.java)
                startActivity(intent1)
                finish()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun navigateBottomEvent() {
        fragmentManager.beginTransaction().apply {
            add(R.id.container, HISTORY_SCREEN, "History").hide(
                HISTORY_SCREEN)
            add(R.id.container, ACCOUNT_SCREEN, "Account").hide(
                ACCOUNT_SCREEN)
            add(R.id.container, FAVORITE_SCREEN, "Favorite").hide(
                FAVORITE_SCREEN)
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
                    fragmentManager.beginTransaction().hide(activeFragment).show(FAVORITE_SCREEN)
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
}