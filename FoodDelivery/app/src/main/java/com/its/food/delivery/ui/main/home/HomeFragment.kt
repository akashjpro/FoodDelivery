package com.its.food.delivery.ui.main.home

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import com.its.food.delivery.R
import com.its.food.delivery.databinding.FragmentHomeBinding
import com.its.food.delivery.ui.BaseFragment2
import com.its.food.delivery.ui.main.MainViewModel
import com.its.food.delivery.ui.my_profile2.MyProfileEditActivity
import com.its.food.delivery.ui.spicy.SpicyChi
import kotlinx.android.synthetic.main.fragment_home.*

/**
 * A simple [Fragment] subclass.
 * Use the [HomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomeFragment : BaseFragment2<FragmentHomeBinding, HomeViewModel, MainViewModel>() {

    @SuppressLint("LogNotTimber")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val listFood: MutableList<Food> = mutableListOf(
            Food(
                "Veggie tomato mix1",
                "19000",
                R.drawable.img_image,
                "Food",
                "Delivered between monday aug and thursday 20 from 8pm to 91:32 pm"
            ),
            Food(
                "Veggie tomato mix1",
                "19000",
                R.drawable.img_image,
                "Food",
                "Delivered between monday aug and thursday 20 from 8pm to 91:32 pm"
            ),
            Food(
                "Veggie tomato mix1",
                "19000",
                R.drawable.img_image,
                "Drink",
                "Delivered between monday aug and thursday 20 from 8pm to 91:32 pm"
            ),
            Food(
                "Veggie tomato mix1",
                "19000",
                R.drawable.img_image,
                "Food",
                "Delivered between monday aug and thursday 20 from 8pm to 91:32 pm"
            ),
            Food(
                "Veggie tomato mix1",
                "19000",
                R.drawable.img_image,
                "Drink",
                "Delivered between monday aug and thursday 20 from 8pm to 91:32 pm"
            ),
            Food(
                "Veggie tomato mix1",
                "19000",
                R.drawable.img_image,
                "Food",
                "Delivered between monday aug and thursday 20 from 8pm to 91:32 pm"
            ),
        )

        // Data binding

        binding = FragmentHomeBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this
        binding.viewModel = this.viewModel

        binding.recyclerviewFoods.adapter = AdapterFoodItem(listFood)
//        binding.editTextSearch.setOnClickListener{
//            var intern = Intent(this.context,SpicyChi::class.java)
//            startActivity(intern)
//        }
//        searchFood()
        init()
//        observe()
        return binding.root
    }

    private fun init() {
        lifecycle.addObserver(viewModel)
    }

//    fun searchFood() {
//        editTextSearch.setOnEditorActionListener { v, actionId, event ->
//            return@setOnEditorActionListener when (actionId) {
//                EditorInfo.IME_ACTION_DONE -> {
//                    nextPage()
//                    true
//                }
//                else -> false
//            }
//        }
//    }

    private fun nextPage() {
        val intent = Intent(this.context, SpicyChi::class.java)
        startActivity(intent)
    }
//    private fun observe() {
//        viewModel.navigateToSpicy.observe(viewLifecycleOwner) { event ->
//            event.getContentIfNotHandled()?.let {
//                val intent = Intent(this.context, SpicyChi::class.java)
//                startActivity(intent)
//            }
//
//        }
//    }

}