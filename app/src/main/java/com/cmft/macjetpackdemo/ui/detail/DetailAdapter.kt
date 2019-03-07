package com.cmft.macjetpackdemo.ui.detail

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.cmft.macjetpackdemo.R
import com.cmft.macjetpackdemo.data.model.Proces

class DetailAdapter : RecyclerView.Adapter<DetailAdapter.DetailHolder>() {
    private var mData: List<Proces>? = null
    private lateinit var mContext: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DetailHolder {
        mContext = parent.context
        val inflate = LayoutInflater.from(parent.context).inflate(R.layout.item_detail_proces, parent, false)
        return DetailHolder(inflate)
    }

    override fun getItemCount(): Int {
        return if (mData.isNullOrEmpty()) 0 else mData!!.size
    }

    override fun onBindViewHolder(holder: DetailHolder, position: Int) {
        val bean = mData?.get(position)
        bean?.run {
            Glide.with(mContext)
                .load(if (pic.isEmpty()) "" else pic)
                .placeholder(R.drawable.default_image)
                .into(holder.imageView)
            holder.textView.text = "$position . $pcontent"
        }
    }

    fun setData(data: List<Proces>) {
        this.mData = data
        notifyDataSetChanged()
    }

    inner class DetailHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView = itemView.findViewById<ImageView>(R.id.mItemDetailIv)
        val textView = itemView.findViewById<TextView>(R.id.mItemDetailTv)
    }
}