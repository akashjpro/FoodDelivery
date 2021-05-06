package com.its.food.delivery.ui.main.home

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.its.food.delivery.R
import com.its.food.delivery.databinding.FragmentHomeBinding
import com.its.food.delivery.ui.BaseFragment2
import com.its.food.delivery.ui.main.MainViewModel
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


//        var tracker = SelectionTracker.Builder(
//            "my-selection-id",
//            recyclerView,
//            StableIdKeyProvider(recyclerView),
//            MyDetailsLookup(recyclerView),
//            StorageStrategy.createLongStorage())
//            .withOnItemActivatedListener(myItemActivatedListener)
//            .build()


        // Data binding

        binding = FragmentHomeBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this
        binding.viewModel = this.viewModel

        binding.recyclerviewFoods.adapter = AdapterFoodItem(listFood)

        return binding.root
    }
}