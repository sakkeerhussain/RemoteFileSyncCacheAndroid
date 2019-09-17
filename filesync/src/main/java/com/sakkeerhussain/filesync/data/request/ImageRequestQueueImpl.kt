package com.sakkeerhussain.filesync.data.request

import com.sakkeerhussain.filesync.data.repository.ImageRepository
import com.sakkeerhussain.filesync.ui.client.BaseTarget
import com.sakkeerhussain.filesync.ui.client.ImageTarget

class ImageRequestQueueImpl(
    private val mImageRepository: ImageRepository
): RequestQueue {

    private val mRequestUtils = RequestUtilsImpl(this)
    val mActiveRequests: ArrayList<ImageRequest> = arrayListOf()

    override fun enqueue(request: Request, target: BaseTarget): Request {
        if (target !is ImageTarget) {
            throw Exception("Target should be Image target for loading image")
        }
        if (request !is ImageRequest) {
            throw Exception("Request should be Image request for loading image")
        }
        return this.enqueue(request, target)
    }

    // Can be consider moving this to a common target class
    @Synchronized
    fun enqueue(request: ImageRequest, target: ImageTarget): Request {

        val existingRequest = mRequestUtils.getExistingImageRequest(request)

        return if (existingRequest != null) {

            existingRequest.targets.add(target)
            existingRequest
        } else {

            mActiveRequests.add(request)
            mImageRepository.getImage(request)
            request
        }
    }
}