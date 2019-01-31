package com.iamsdt.paging.room_network

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.iamsdt.paging.R
import com.iamsdt.paging.db.MyDB
import com.iamsdt.paging.room.RoomAdapter
import com.iamsdt.paging.room.RoomVM
import kotlinx.android.synthetic.main.activity_room.*

class RoomNetActivity : AppCompatActivity() {

    private val vm: MyVM by lazy {
        ViewModelProviders.of(this).get(MyVM::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_room_net)

        //recycler view
        rcv.layoutManager = LinearLayoutManager(this)
        val adapter = MyAdapter()
        rcv.adapter = adapter

        //getDatabase
        val dao = MyDB.getStackDao(this)

        vm.data(dao).observe(this, Observer {
            adapter.submitList(it)
        })

    }
}
