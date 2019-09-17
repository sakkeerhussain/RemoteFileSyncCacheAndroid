package com.sakkeerhussain.filesync.data.request

import com.sakkeerhussain.filesync.client.BaseTarget

class JsonRequestBuilderImpl(
    val queue: RequestQueue,
    override var url: String
) : RequestBuilder{

    override var headers: HashMap<String, String> = hashMapOf()

    override fun addHeader(name: String, value: String): RequestBuilder {
        this.headers[name] = value
        return this
    }

    override fun toTarget(target: BaseTarget) {
        // TODO - Enqueue request here
    }

}