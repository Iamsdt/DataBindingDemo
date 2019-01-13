package com.iamsdt.navigationcom.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.iamsdt.navigationcom.R
import kotlinx.android.synthetic.main.login_fragment.*

class LoginFrgament : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.login_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        login.setOnClickListener {
            val action = LoginFrgamentDirections.actionUpdate()
            Navigation.findNavController(it).navigate(action)
        }

        signup.setOnClickListener {
            val action = LoginFrgamentDirections.actionSignup()
            Navigation.findNavController(it).navigate(action)
        }
    }

}