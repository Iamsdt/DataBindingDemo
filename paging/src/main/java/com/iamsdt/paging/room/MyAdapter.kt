package com.iamsdt.paging.room

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.iamsdt.paging.db.Photos

class MyAdapter : ListAdapter<Photos, MyAdapter.MyViewHolder>(diffs) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val model = getItem(position)
    }

    companion object {
        val diffs = object : DiffUtil.ItemCallback<Photos>() {
            override fun areItemsTheSame(oldItem: Photos, newItem: Photos) =
                oldItem.id == newItem.id

            override fun areContentsTheSame(oldItem: Photos, newItem: Photos) =
                oldItem == newItem

        }
    }

    inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view)
}
