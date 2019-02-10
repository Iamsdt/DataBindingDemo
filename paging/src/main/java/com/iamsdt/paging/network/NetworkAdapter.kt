package com.iamsdt.paging.network

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.iamsdt.paging.R
import com.iamsdt.paging.db.StackEntity
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item.view.*

class NetworkAdapter : PagedListAdapter<StackEntity, NetworkAdapter.VH>(diff) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item, parent, false)

        return VH(view)
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        val model: StackEntity? = getItem(position)
        model?.let {
            //bind with view
            holder.bind(it)
        }
    }


    companion object {
        val diff = object : DiffUtil.ItemCallback<StackEntity>() {
            override fun areItemsTheSame(oldItem: StackEntity, newItem: StackEntity): Boolean {
                return oldItem.name == newItem.name
            }

            override fun areContentsTheSame(oldItem: StackEntity, newItem: StackEntity): Boolean {
                return oldItem == newItem
            }

        }
    }

    inner class VH(view: View) : RecyclerView.ViewHolder(view) {

        private val tv = view.textViewName
        private val img = view.imageView

        fun bind(model: StackEntity) {
            tv.text = model.name
            Picasso.get().load(model.img).into(img)
        }

    }
}