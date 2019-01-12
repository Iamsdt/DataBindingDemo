package com.iamsdt.databinding

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.iamsdt.databinding.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)

        val viewModel = ViewModelProviders.of(this).get(MainVM::class.java)

        val main = DataBindingUtil.setContentView<ActivityMainBinding>(
            this, R.layout.activity_main
        )
        setSupportActionBar(main.toolbar)
        main.setLifecycleOwner(this)
        main.vm = viewModel
    }
}
