package com.jar.yu.handle_thread

import android.os.Bundle
import android.os.Handler
import android.os.HandlerThread
import android.os.Message
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.jar.yu.R

class HandleThreadActivity : AppCompatActivity() {

    private var mHandleThread: HandlerThread? = null
    var mCheckMsgHandler: Handler? = null
    var tvTime: TextView? = null
    private var btnStart: Button? = null
    var btnStop: Button? = null
    var isUpdate = false

    companion object {

        private var MSG_UPDATE_INFO = 300
        private const val TAG = "HandleThreadActivity : "
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_handle_thread)
        tvTime = findViewById(R.id.tv_msg_update)

        btnStart = findViewById(R.id.btn_test_handle_thread_start)
        btnStop = findViewById(R.id.btn_test_handle_thread_stop)

        initEvent()
        initBackThread()

    }


    private fun initEvent() {
        btnStart?.setOnClickListener {
            isUpdate = true
            mCheckMsgHandler?.sendEmptyMessage(MSG_UPDATE_INFO)
        }

        btnStop?.setOnClickListener {
            isUpdate = false
            mCheckMsgHandler?.sendEmptyMessage(MSG_UPDATE_INFO)
        }
    }

    private fun initBackThread() {
        mHandleThread = HandlerThread("check-message-coming")
        mHandleThread?.start()

        mHandleThread?.let {
            mCheckMsgHandler = object : Handler(it.looper) {
                override fun handleMessage(msg: Message) {
                    super.handleMessage(msg)
                    Thread.sleep(1000)
                    runOnUiThread {
                        val result = "间隔1s 更新一下数据：" + Math.random()
                        tvTime?.text = result
                    }

                    if (isUpdate) {
                        Log.d(TAG, "handleMessage:  延迟1s发送消息...")
                       //  mCheckMsgHandler?.sendEmptyMessageDelayed(MSG_UPDATE_INFO, 1000);
                    }
                }
            }
        }
    }

    override fun onPause() {
        super.onPause()
        isUpdate = false
        mCheckMsgHandler?.removeMessages(MSG_UPDATE_INFO)
    }

    override fun onDestroy() {
        super.onDestroy()

        mHandleThread?.quit()
    }


}