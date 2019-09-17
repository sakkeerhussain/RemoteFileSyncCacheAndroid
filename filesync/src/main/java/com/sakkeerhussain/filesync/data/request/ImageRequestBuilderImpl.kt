package com.sakkeerhussain.filesync.data.request

import android.widget.ImageView
import com.sakkeerhussain.filesync.ui.client.BaseTarget
import com.sakkeerhussain.filesync.ui.client.ImageViewTarget

class ImageRequestBuilderImpl(val mQueue: RequestQueue, override var url: String) : ImageRequestBuilder{

    override var headers: HashMap<String, String> = hashMapOf()

    override fun addHeader(name: String, value: String): ImageRequestBuilderImpl {
        this.headers[name] = value
        return this
    }

    override fun toTarget(target: BaseTarget) {

        val request = this.build()
        mQueue.enqueue(request, target)
    }

    override fun toTarget(target: ImageView) {
        this.toTarget(ImageViewTarget(target))
    }

    private fun build(): ImageRequest {
        val request = ImageRequest(this.url)
        request.headers = this.headers
        return request
    }

}