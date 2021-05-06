package com.its.food.delivery.ui.main.account

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.its.food.delivery.R
import com.its.food.delivery.ui.my_profile2.MyProfile2Activity


/**
 * A simple [Fragment] subclass.
 * Use the [AccountFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class AccountFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_account, container, false)
    }
//    fun onClickEditProfile(view: View) {
//        val intent = Intent(this@AccountFragment, MyProfile2Activity::class.java)
//        startActivity(intent)
//        finish()
//    }
}