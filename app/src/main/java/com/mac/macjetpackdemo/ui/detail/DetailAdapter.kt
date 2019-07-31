package com.mac.macjetpackdemo.ui.detail

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.mac.macjetpackdemo.R
import com.mac.macjetpackdemo.data.model.DetailResult
import com.mac.macjetpackdemo.data.model.Proces
import com.mac.macjetpackdemo.util.GlideUtil

class DetailAdapter : RecyclerView.Adapter<DetailAdapter.DetailHolder>() {
    private var mData: DetailResult.Result? = null
    private var mProcesList: List<Proces>? = null
    private lateinit var mContext: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DetailHolder {
        mContext = parent.context
        val inflate = LayoutInflater.from(parent.context).inflate(viewType, parent, false)
        return DetailHolder(inflate)
    }

    override fun getItemCount(): Int {
        return if (mProcesList.isNullOrEmpty()) 0 else mProcesList!!.size + 1
    }

    override fun onBindViewHolder(holder: DetailHolder, position: Int) {
        when (position) {
            0 -> {
                mData?.run {
//                    holder.mFoodName.text = name
                    holder.mFoodContent.text = content
//                    Glide.with(mContext)
//                        .load(if (pic.isEmpty()) "" else pic)
//                        .placeholder(R.drawable.default_image)
//                        .into(holder.mFoodPic)
                    val sb = StringBuffer()
                    material?.forEach {
                        sb.append("${it.mname}${it.amount} 、")
                    }
                    holder.mDetailMaterialTv.text = sb
                }
            }
            else -> {
                val bean = mProcesList?.get(position - 1)
                bean?.run {
                    GlideUtil.loadIntoUseFitWidth(
                        mContext,
                        if (pic.isEmpty()) "" else pic,
                        R.drawable.default_image,
                        holder.imageView
                    )

                    holder.textView.text = "$position . $pcontent"
                }
            }
        }

    }

    override fun getItemViewType(position: Int): Int {
        return when (position) {
            0 -> {
                R.layout.item_detail_content
            }
            else -> {
                R.layout.item_detail_proces
            }
        }
    }

    fun setData(data: DetailResult.Result) {
        this.mData = data
        this.mProcesList = data.process
        notifyDataSetChanged()
    }

    inner class DetailHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView = itemView.findViewById<ImageView>(R.id.mItemDetailIv)
        val textView = itemView.findViewById<TextView>(R.id.mItemDetailTv)
        val mFoodName = itemView.findViewById<TextView>(R.id.mFoodNameTv)
        val mFoodContent = itemView.findViewById<TextView>(R.id.mFoodDescTv)
        val mFoodPic = itemView.findViewById<ImageView>(R.id.mFoodPicIv)
        val mDetailMaterialTv = itemView.findViewById<TextView>(R.id.mDetailMaterialTv)
    }
}