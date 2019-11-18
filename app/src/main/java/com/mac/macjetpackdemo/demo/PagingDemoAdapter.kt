package com.mac.macjetpackdemo.demo

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.mac.macjetpackdemo.R

class PagingDemoAdapter : PagedListAdapter<DemoModel, PagingDemoAdapter.DemoHolder>(diffCallback) {
    companion object {
        private val diffCallback = object : DiffUtil.ItemCallback<DemoModel>() {
            override fun areItemsTheSame(oldItem: DemoModel, newItem: DemoModel): Boolean = oldItem.id == newItem.id

            override fun areContentsTheSame(oldItem: DemoModel, newItem: DemoModel): Boolean = oldItem == newItem
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DemoHolder {
        return DemoHolder(parent)
    }

    override fun onBindViewHolder(holder: DemoHolder, position: Int) {
        holder.bindTo(getItem(position))
    }

    inner class DemoHolder(parent: ViewGroup) : RecyclerView.ViewHolder(
        LayoutInflater.from(parent.context).inflate(
            R.layout.item_demo,
            parent,
            false
        )
    ) {
        private val nameView = itemView.findViewById<TextView>(R.id.item_demo_name)
        private val idView = itemView.findViewById<TextView>(R.id.item_demo_id)

        fun bindTo(model: DemoModel?) {
            nameView.text = model?.name
            idView.text = model?.id.toString()
        }
    }
}