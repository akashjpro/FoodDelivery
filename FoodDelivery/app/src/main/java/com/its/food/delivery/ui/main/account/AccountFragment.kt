package com.its.food.delivery.ui.main.account

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.its.food.delivery.databinding.FragmentAccountBinding
import com.its.food.delivery.ui.BaseFragment2
import com.its.food.delivery.ui.main.MainViewModel
import com.its.food.delivery.ui.my_profile2.MyProfileEditActivity
import dagger.hilt.android.AndroidEntryPoint


/**
 * A simple [Fragment] subclass.
 * Use the [AccountFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
@AndroidEntryPoint
class AccountFragment : BaseFragment2<FragmentAccountBinding,AccountViewModel,MainViewModel>() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Data binding
        binding = FragmentAccountBinding.inflate(inflater,container,false)
        binding.lifecycleOwner = this
        binding.viewModel = this.viewModel
        init()
        observe()
        return binding.root
    }
    private fun init() {
        lifecycle.addObserver(viewModel)
    }

    private fun observe() {
        viewModel.navigateToEditProfile.observe(viewLifecycleOwner) { event ->
            event.getContentIfNotHandled()?.let {
                val intent = Intent(this.context, MyProfileEditActivity::class.java)
                startActivity(intent)
            }

        }
    }

}