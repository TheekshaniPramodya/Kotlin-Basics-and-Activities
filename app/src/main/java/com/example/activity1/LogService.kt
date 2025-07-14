package com.example.activity1

import android.app.Service.START_STICKY
import android.content.Intent
import android.nfc.Tag
import android.os.IBinder
import android.util.Log
import java.security.Provider.Service

class LogService :android.app.Service(){
    private val TAG ="LogService"
    override fun onCreate(){
        super.onCreate()
        Log.d(TAG,"onCreate")

    }
    override fun onStartCommand(intent: Intent?, flags:Int, startId:Int):Int{
        Log.d(TAG,"onStartCommand")
        return START_STICKY
    }

    override fun onBind(intent: Intent?): IBinder?{
        Log.d(TAG,"onBind")
        return null
    }
    override fun onDestroy(){
        super.onDestroy()
        Log.d(TAG,"onDestroy")

    }
}