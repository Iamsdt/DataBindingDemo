package com.iamsdt.paging.room

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.iamsdt.paging.R
import com.iamsdt.paging.db.Photos
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item.view.*

class RoomAdapter : PagedListAdapter<Photos, RoomAdapter.VH>(diff) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item, parent, false)

        return VH(view)
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        val model: Photos? = getItem(position)
        model?.let {
            //bind with view
            holder.bind(it)
        }
    }


    companion object {
        val diff = object : DiffUtil.ItemCallback<Photos>() {
            override fun areItemsTheSame(oldItem: Photos, newItem: Photos): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: Photos, newItem: Photos): Boolean {
                return oldItem == newItem
            }

        }
    }

    inner class VH(view: View) : RecyclerView.ViewHolder(view) {

        private val tv = view.textViewName
        private val img = view.imageView

        fun bind(model: Photos) {
            tv.text = model.title
            Picasso.get().load(model.thumbnailUrl).into(img)
        }

    }
}