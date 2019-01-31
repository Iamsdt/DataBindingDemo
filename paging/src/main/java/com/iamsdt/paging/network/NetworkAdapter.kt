package com.iamsdt.paging.network

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.iamsdt.paging.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item.view.*

class NetworkAdapter : PagedListAdapter<Item, NetworkAdapter.VH>(diff) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item, parent, false)

        return VH(view)
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        val model: Item? = getItem(position)
        model?.let {
            //bind with view
            holder.bind(it)
        }
    }


    companion object {
        val diff = object : DiffUtil.ItemCallback<Item>() {
            override fun areItemsTheSame(oldItem: Item, newItem: Item): Boolean {
                return oldItem.answer_id == newItem.answer_id
            }

            override fun areContentsTheSame(oldItem: Item, newItem: Item): Boolean {
                return oldItem == newItem
            }

        }
    }

    inner class VH(view: View) : RecyclerView.ViewHolder(view) {

        private val tv = view.textViewName
        private val img = view.imageView

        fun bind(model: Item) {
            tv.text = model.owner?.display_name ?: "No name found"
            Picasso.get().load(model.owner?.profile_image).into(img)
        }

    }
}