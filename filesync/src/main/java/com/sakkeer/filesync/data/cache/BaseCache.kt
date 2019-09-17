package com.sakkeer.filesync.data.cache

import com.sakkeer.filesync.data.callback.ResponseCallback
import com.sakkeer.filesync.data.request.Request

/*
 * Created by Sakkeer Hussain on 2019-09-15.
 */
interface BaseCache {
    fun get(request: Request, callback: ResponseCallback): Boolean
    fun cache(request: Request, data: Any)
    fun clearCache()
}