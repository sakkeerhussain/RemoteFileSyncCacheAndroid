package com.zyncy.data.request

import android.widget.ImageView
import com.zyncy.client.BaseTarget
import com.zyncy.client.ImageViewTarget
import com.zyncy.data.repository.ImageRepository

class ImageRequestBuilderImpl(
    private val mImageRepository: ImageRepository,
    override var url: String
) : ImageRequestBuilder{

    override var headers: HashMap<String, String> = hashMapOf()
    private var placeHolderImageResource: Int? = null
    private var errorImageResource: Int? = null

    override fun addHeader(name: String, value: String): ImageRequestBuilderImpl {
        this.headers[name] = value
        return this
    }

    override fun placeholder(imgResource: Int): ImageRequestBuilderImpl {
        this.placeHolderImageResource = imgResource
        return this
    }

    override fun errorImage(imgResource: Int): ImageRequestBuilderImpl {
        this.errorImageResource = imgResource
        return this
    }

    override fun toTarget(target: BaseTarget): Request {
        val request = this.build()
        mImageRepository.getImage(request, target)

        // Preparing response request
        request.targets = arrayListOf(target)
        return request
    }

    override fun toTarget(target: ImageView): Request {
        return this.toTarget(ImageViewTarget(target))
    }

    private fun build(): ImageRequest {
        val request = ImageRequest(this.url)
        request.repository = this.mImageRepository
        request.headers = this.headers
        request.placeHolderImageResource = this.placeHolderImageResource
        request.errorImageResource = this.errorImageResource
        return request
    }

}