package com.iamsdt.paging.network

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.iamsdt.paging.R
import kotlinx.android.synthetic.main.activity_room.*

class NetworkActivity : AppCompatActivity() {

    private val vm: NetworkViewModel by lazy {
        ViewModelProviders.of(this).get(NetworkViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_network)

        //recycler view
        rcv.layoutManager = LinearLayoutManager(this)
        val adapter = NetworkAdapter()
        rcv.adapter = adapter

        vm.data.observe(this, Observer {
            adapter.submitList(it)
        })

    }
}
