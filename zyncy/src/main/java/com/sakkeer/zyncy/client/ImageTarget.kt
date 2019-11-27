package com.sakkeer.zyncy.client

import android.graphics.Bitmap

interface ImageTarget: BaseTarget {

    fun loadImage(img: Int)
    fun loadImage(bmp: Bitmap)
}