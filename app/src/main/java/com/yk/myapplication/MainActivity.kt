package com.yk.myapplication

import android.os.Bundle
import android.os.Environment
import android.support.v7.app.AppCompatActivity
import android.widget.TextView
import android.widget.Toast


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<TextView>(R.id.tv).setOnClickListener {
            val s = Environment.getExternalStorageDirectory().path + "/billlibrary-debug-androidTest.apk"
//            runShell("pm uninstall com.example.billlibrary.test")
            runShell("666");
        }
    }

    private fun runShell(cmd: String) {
        Thread(Runnable {
        SocketClient(cmd,SocketClient.onServiceSend {
            runOnUiThread {
               Toast.makeText(this,"$it",0).show()

            }

        })

        }).start()

    }
}
