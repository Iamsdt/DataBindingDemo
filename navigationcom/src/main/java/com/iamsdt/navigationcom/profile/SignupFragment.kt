package com.iamsdt.navigationcom.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavDirections
import androidx.navigation.Navigation
import com.iamsdt.navigationcom.R
import kotlinx.android.synthetic.main.signup_fragment.*

class SignupFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.signup_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        signup.setOnClickListener {
            SignupFragmentDirections.actionLogin().navigate(it)
        }
    }

}

fun NavDirections.navigate(view: View) {
    Navigation.findNavController(view).navigate(this)
}