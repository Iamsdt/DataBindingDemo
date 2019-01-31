package com.iamsdt.paging.room

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.iamsdt.paging.R
import com.iamsdt.paging.db.MyDB
import kotlinx.android.synthetic.main.activity_room.*

class RoomActivity : AppCompatActivity() {

    private val vm: RoomVM by lazy {
        ViewModelProviders.of(this).get(RoomVM::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_room)

        //recycler view
        rcv.layoutManager = LinearLayoutManager(this)
        val adapter = RoomAdapter()
        rcv.adapter = adapter

        //getDatabase
        val dao = MyDB.getDao(this)

        vm.data(dao).observe(this, Observer {
            adapter.submitList(it)
        })

    }
}
