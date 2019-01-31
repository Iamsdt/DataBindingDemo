package com.iamsdt.paging

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.work.ExistingWorkPolicy
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import com.google.android.material.button.MaterialButton
import com.iamsdt.paging.network.NetworkActivity
import com.iamsdt.paging.room.RoomActivity
import com.iamsdt.paging.room_network.RoomNetActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.reflect.KClass

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        room.click(RoomActivity::class)
        network.click(NetworkActivity::class)
        room_network.click(RoomNetActivity::class)

        insertData()
    }

    private fun MaterialButton.click(clazz: KClass<out AppCompatActivity>) {
        this.setOnClickListener {
            startActivity(Intent(this@MainActivity, clazz.java))
        }
    }

    private fun insertData() {
        val builder = OneTimeWorkRequestBuilder<DataInsert>()
            .build()
        WorkManager.getInstance().enqueueUniqueWork(
            "DataInsert", ExistingWorkPolicy.KEEP, builder
        )
    }
}
