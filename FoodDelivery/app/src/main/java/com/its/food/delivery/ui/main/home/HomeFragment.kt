package com.its.food.delivery.ui.main.home

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.KeyEvent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.android.material.tabs.TabLayout
import com.its.food.delivery.adapters.FoodAdapter
import com.its.food.delivery.databinding.FragmentHomeBinding
import com.its.food.delivery.delivery_interface.ExampleListFood
import com.its.food.delivery.ui.BaseFragment2
import com.its.food.delivery.ui.food_in_formation.FoodInformationActivity
import com.its.food.delivery.ui.main.MainActivity
import com.its.food.delivery.ui.main.MainViewModel
import com.its.food.delivery.ui.main.home.tab_fragment.DrinksFragment
import com.its.food.delivery.ui.main.home.tab_fragment.FoodsFragment
import com.its.food.delivery.ui.main.home.tab_fragment.SnacksFragment
import com.its.food.delivery.ui.spicy.SpicyChiActivity
import com.its.food.delivery.util.BUNDLE_KEY
import com.its.food.delivery.util.FOOD_ENTITY_KEY
import com.its.food.delivery.util.SEARCH_KEY
import kotlinx.android.synthetic.main.activity_food_information.*
import kotlinx.android.synthetic.main.fragment_home.*

/**
 * A simple [Fragment] subclass.
 * Use the [HomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
@Suppress("DEPRECATION")
class HomeFragment : BaseFragment2<FragmentHomeBinding, HomeViewModel, MainViewModel>(),
    ExampleListFood {
    @SuppressLint("LogNotTimber")
    private val exampleListFood = exampleLis()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        init()

        // Data binding
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this
        binding.viewModel = this.viewModel

        val foodAdapter = FoodAdapter(onItemClick = {
            val intent = Intent(this.context, FoodInformationActivity::class.java)
            val bundle = Bundle()
            bundle.putSerializable(FOOD_ENTITY_KEY, it)
            intent.putExtra(BUNDLE_KEY, bundle)
            startActivity(intent)
        })

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


        binding.tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            @SuppressLint("LogNotTimber")
            override fun onTabSelected(tab: TabLayout.Tab) {

//                var fragment: Fragment? = null
                when (tab.position) {
                    0 -> {

                    }
                    1 -> {
                    }
                    2 -> {
                    }
                }
//                if (fragment != null) {
//                    fragmentManager = getSupportFragmentManager()
//                }

//                Log.d("aaaa", tabAdapter.getItem(tab.position).toString())
            }

            override fun onTabUnselected(tab: TabLayout.Tab) {
            }

            override fun onTabReselected(tab: TabLayout.Tab) {
            }
        })



        binding.recyclerviewFoods.adapter = foodAdapter

        //Update list food
        foodAdapter.submitList(exampleListFood)




        return binding.root
    }

    @SuppressLint("LogNotTimber")
    fun searchFood() {
        val intent = Intent(this.context, SpicyChiActivity::class.java)
        val i = binding.editTextSearch.text.toString().trim()
        val bundle = Bundle()
        bundle.putString("KEY", i)
        intent.putExtra(SEARCH_KEY, bundle)
        startActivity(intent)
    }

    private fun init() {
        lifecycle.addObserver(viewModel)
    }
}