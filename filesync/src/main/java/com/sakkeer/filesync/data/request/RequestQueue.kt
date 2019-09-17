package com.sakkeer.filesync.data.request

import com.sakkeer.filesync.client.BaseTarget

interface RequestQueue {
    fun enqueue(request: Request, target: BaseTarget): Request
}