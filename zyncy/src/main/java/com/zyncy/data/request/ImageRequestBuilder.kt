package com.zyncy.data.request

import android.widget.ImageView
import com.zyncy.client.BaseTarget

interface ImageRequestBuilder : RequestBuilder {

    override fun addHeader(name: String, value: String): ImageRequestBuilder
    override fun toTarget(target: BaseTarget): Request
    fun placeholder(imgResource: Int): ImageRequestBuilderImpl
    fun errorImage(imgResource: Int): ImageRequestBuilderImpl


    // Additional util functions
    fun toTarget(target: ImageView): Request
}