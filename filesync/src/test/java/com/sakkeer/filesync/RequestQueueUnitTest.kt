package com.sakkeer.filesync

import com.sakkeer.filesync.client.ImageTarget
import com.sakkeer.filesync.data.cache.ImageCacheDao
import com.sakkeer.filesync.data.remote.ImageServiceDao
import com.sakkeer.filesync.data.repository.ImageRepositoryImpl
import com.sakkeer.filesync.data.request.ImageRequest
import com.sakkeer.filesync.data.request.RequestQueueImpl
import org.junit.Assert.assertEquals
import org.junit.Test
import org.mockito.Mockito

class RequestQueueUnitTest {

    val TEST_URL = "http://test.com/photo.jpg"

    @Test
    fun multipleRequestToSameUrlTest() {

        val imageService = Mockito.mock(ImageServiceDao::class.java)
        val imageCache = Mockito.mock(ImageCacheDao::class.java)
        val requestQueue = RequestQueueImpl()
        val mockImageRepository = ImageRepositoryImpl(imageService, imageCache, requestQueue)

        val mockTarget1 = Mockito.mock(ImageTarget::class.java)
        val mockTarget2 = Mockito.mock(ImageTarget::class.java)
        val request1 = ImageRequest(TEST_URL)
        val request2 = ImageRequest(TEST_URL)

        val respRequest1 = mockImageRepository.getImage(request1, mockTarget1)
        val respRequest2 = mockImageRepository.getImage(request2, mockTarget2)

        assertEquals(respRequest1, respRequest2)
        assertEquals(respRequest1.targets.size, 2)
    }
}