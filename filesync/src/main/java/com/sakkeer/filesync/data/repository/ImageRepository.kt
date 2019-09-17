package com.sakkeer.filesync.data.repository

import com.sakkeer.filesync.client.BaseTarget
import com.sakkeer.filesync.data.request.Request

/*
 * Created by Sakkeer Hussain on 2019-09-14.
 */
interface ImageRepository {
    fun getImage(request: Request, target: BaseTarget)
    fun dequeRequest(request: Request)
}