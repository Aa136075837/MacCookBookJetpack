package com.cmft.macjetpackdemo.util

import android.content.Context
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.resource.drawable.GlideDrawable
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target

object GlideUtil {
    fun loadIntoUseFitWidth(context: Context?, imageUrl: String, errorImageId: Int, imageView: ImageView?) {
        if (context == null) {
            return
        }
        Glide.with(context)
            .load(imageUrl)
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .listener(object : RequestListener<String, GlideDrawable> {
                override fun onException(
                    e: Exception,
                    model: String,
                    target: Target<GlideDrawable>,
                    isFirstResource: Boolean
                ): Boolean {
                    return false
                }

                override fun onResourceReady(
                    resource: GlideDrawable,
                    model: String,
                    target: Target<GlideDrawable>,
                    isFromMemoryCache: Boolean,
                    isFirstResource: Boolean
                ): Boolean {
                    if (imageView == null) {
                        return false
                    }
                    if (imageView.scaleType != ImageView.ScaleType.FIT_XY) {
                        imageView.scaleType = ImageView.ScaleType.FIT_XY
                    }
                    val params = imageView.layoutParams
                    val vw = imageView.width - imageView.paddingLeft - imageView.paddingRight
                    val scale = vw.toFloat() / resource.intrinsicWidth.toFloat()
                    val vh = Math.round(resource.intrinsicHeight * scale)
                    params.height = vh + imageView.paddingTop + imageView.paddingBottom
                    imageView.layoutParams = params
                    return false
                }
            })

            .placeholder(errorImageId)
            .dontAnimate()
            .error(errorImageId)
            .into(imageView!!)
    }
}