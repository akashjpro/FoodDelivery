package com.its.food.delivery.ui.main.home

import com.its.food.delivery.ui.result.ResultActivity
import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.KeyEvent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.google.android.material.tabs.TabLayoutMediator
import com.its.food.delivery.databinding.FragmentHomeBinding
import com.its.food.delivery.delivery_interface.ExampleListFood
import com.its.food.delivery.ui.BaseFragment2
import com.its.food.delivery.ui.main.MainViewModel
import com.its.food.delivery.ui.main.home.tab_fragment.DrinksFragment
import com.its.food.delivery.ui.main.home.tab_fragment.FoodsFragment
import com.its.food.delivery.ui.main.home.tab_fragment.SnacksFragment
import com.its.food.delivery.ui.see_more.SeeMoreActivity
import com.its.food.delivery.util.SEARCH_KEY
import com.its.food.delivery.util.TEXT_TAB
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_food_information.*
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.item_recyclerview_food_home.view.*

/**
 * A simple [Fragment] subclass.
 * Use the [HomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
@Suppress("DEPRECATION")
@AndroidEntryPoint
class HomeFragment : BaseFragment2<FragmentHomeBinding, HomeViewModel, MainViewModel>(),
    ExampleListFood {
    @SuppressLint("LogNotTimber")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        init()

        // Data binding
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this
        binding.viewModel = this.viewModel

        binding.editTextSearch.setOnKeyListener(object : View.OnKeyListener {
            override fun onKey(v: View?, keyCode: Int, event: KeyEvent): Boolean {
                if (event.action == KeyEvent.ACTION_DOWN) {
                    when (keyCode) {
                        KeyEvent.KEYCODE_DPAD_CENTER, KeyEvent.KEYCODE_ENTER -> {
                            searchFood()
                            return true
                        }
                        else -> {
                        }
                    }
                }
                return false
            }
        })

        binding.viewPager2Home.adapter = TabViewPagerAdapter(this)
        TabLayoutMediator(binding.tabLayout, binding.viewPager2Home) { tab, position ->
            when (position) {
                0 -> {
                    tab.text = "Foods"
                }
                1 -> {
                    tab.text = "Drinks"
                }
                2 -> {
                    tab.text = "Snacks"
                }
            }
        }.attach()

// ===================== Test ==============================
        binding.txtSeeMore.setOnClickListener {
            val titleTab = tabSelect(binding.tabLayout.selectedTabPosition)

            Log.d("AAAA", "Tab position: ${binding.tabLayout.selectedTabPosition}")
            Log.d("AAAA", "Tab Title: ${tabSelect(binding.tabLayout.selectedTabPosition)}")

            val intent = Intent(this.context, SeeMoreActivity::class.java)
            intent.putExtra(TEXT_TAB, titleTab)
            startActivity(intent)
        }
// =========================================================

        return binding.root
    }

    fun tabSelect(position: Int): String {
        var titleTab = ""
        when (position) {
            0 -> titleTab = "Food"
            1 -> titleTab = "Drink"
            2 -> titleTab = "Snack"
        }
        return titleTab
    }

    @SuppressLint("LogNotTimber")
    fun searchFood() {
        val intent = Intent(this.context, ResultActivity::class.java)
        val i = binding.editTextSearch.text.toString().trim()
        val bundle = Bundle()
        bundle.putString("KEY", i)
        intent.putExtra(SEARCH_KEY, bundle)
        startActivity(intent)
    }

    private fun init() {
        lifecycle.addObserver(viewModel)
    }

    private class TabViewPagerAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {

        override fun getItemCount(): Int = 3

        override fun createFragment(position: Int): Fragment =
            when (position) {
                0 -> {
                    FoodsFragment()
                }
                1 -> {
                    DrinksFragment()
                }
                2 -> {
                    SnacksFragment()
                }
                else -> throw IllegalArgumentException("Provide fragment")
            }
    }
}