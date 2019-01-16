package com.iamsdt.navigationcom

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item.view.*

class MyAdapter : ListAdapter<String, MyAdapter.VH>(diff) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val v = LayoutInflater.from(parent.context)
            .inflate(R.layout.item, parent, false)
        return VH(v)
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        val str: String? = getItem(position)
        str?.let { s ->
            holder.bind(s)

            holder.itemView.setOnClickListener {
                val action = PhotosFragmentDirections.actionDetails()
                action.listOfStr = s
                Navigation.findNavController(it).navigate(action)
            }
        }
    }


    companion object {
        val diff = object : DiffUtil.ItemCallback<String>() {
            override fun areItemsTheSame(oldItem: String, newItem: String): Boolean {
                return oldItem.length == newItem.length
            }

            override fun areContentsTheSame(oldItem: String, newItem: String): Boolean {
                return oldItem == newItem
            }

        }
    }

    class VH(view: View) : RecyclerView.ViewHolder(view) {
        private val tv = view.tv

        fun bind(str: String) {
            tv.text = str
        }
    }
}