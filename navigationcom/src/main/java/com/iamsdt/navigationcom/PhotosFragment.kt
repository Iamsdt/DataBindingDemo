package com.iamsdt.navigationcom

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_photos.*
import java.util.*


class PhotosFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_photos, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = MyAdapter()
        adapter.submitList(getList())

        rcv.layoutManager = LinearLayoutManager(context)
        rcv.adapter = adapter
    }

    private fun getList(): ArrayList<String> {
        val arrayList = arrayListOf<String>()
        for (i in 0 until 100) {
            arrayList.add("Title: $i")
        }

        return arrayList
    }

}