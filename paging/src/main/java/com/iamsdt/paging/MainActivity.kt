package com.iamsdt.paging

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton
import com.iamsdt.paging.room.RoomActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.reflect.KClass

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        room.click(RoomActivity::class)
    }

    private fun MaterialButton.click(clazz: KClass<out AppCompatActivity>) {
        this.setOnClickListener {
            startActivity(Intent(this@MainActivity, clazz.java))
        }
    }
}
