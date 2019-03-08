package com.cmft.macjetpackdemo.ui.search

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.cmft.macjetpackdemo.R
import com.cmft.macjetpackdemo.data.model.SearchResult
import com.cmft.macjetpackdemo.ui.detail.DetailActivity

class SearchResultAdapter : RecyclerView.Adapter<SearchResultAdapter.SearchResultHolder>() {
    private var data: List<SearchResult.ResultX.X>? = null
    private lateinit var mContext: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchResultHolder {
        mContext = parent.context
        val view = LayoutInflater.from(mContext).inflate(R.layout.item_search_result, parent, false)
        return SearchResultHolder(view)
    }

    override fun getItemCount(): Int {
        return if (data.isNullOrEmpty()) 0 else data?.size!!
    }

    override fun onBindViewHolder(holder: SearchResultHolder, position: Int) {
        val bean = data?.get(position)
        bean?.run {
            holder.mFoodName.text = name
            holder.mFitNum.text = peoplenum
            holder.mCookTime.text = cookingtime
            Glide.with(mContext)
                .load(if (pic.isEmpty()) "" else pic)
                .placeholder(R.drawable.default_image)
                .into(holder.mItemIv)

            holder.itemView.setOnClickListener {
                val intent = Intent(mContext, DetailActivity::class.java)
                intent.putExtra(DetailActivity.DETAIL_CLASSID, id)
                intent.putExtra(DetailActivity.DETAIL_NAME, name)
                mContext.startActivity(intent)
            }
        }
    }

    fun setData(data: List<SearchResult.ResultX.X>) {
        this.data = data
        notifyDataSetChanged()
    }

    inner class SearchResultHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val mFoodName = itemView.findViewById<TextView>(R.id.mFoodNameTv)
        val mFitNum = itemView.findViewById<TextView>(R.id.mFitNumTv)
        val mCookTime = itemView.findViewById<TextView>(R.id.mCookTimeTv)
        val mItemIv = itemView.findViewById<ImageView>(R.id.mItemIv)
    }
}