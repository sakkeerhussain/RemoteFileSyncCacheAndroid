package com.sakkeer.filesync.sample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.sakkeer.filesync.data.request.Request

class CustomViewActivity : AppCompatActivity() {

    private lateinit var mRequest: Request

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_custom_view)
    }
}
