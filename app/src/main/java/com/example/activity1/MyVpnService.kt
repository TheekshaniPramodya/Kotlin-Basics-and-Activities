package com.example.activity1

import android.content.Intent
import android.net.VpnService
import android.os.ParcelFileDescriptor
import android.util.Log

class MyVpnService: VpnService() {
    private val TAG = "VpnService"
    private var vpnInterface: ParcelFileDescriptor? = null
    companion object{
        const val ACTION_CONNECT_VPN = "com.example.activity1.ACTION_CONNECT_VPN"
        const val ACTION_DISCONNECT_VPN = "com.example.activity1.ACTION_DISCONNECT_VPN"
        const val EXTRA_SERVICE_CONFIG_FILE = "com.example.activity1.EXTRA_CONFIG_PATH"
    }
    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Log.d(TAG, "onStartCommand.Action=${intent?.action}")
        when (intent?.action) {
            ACTION_CONNECT_VPN -> {
                val configPath = intent.getStringExtra(EXTRA_SERVICE_CONFIG_FILE)
                if (configPath != null) {
                    Log.i(TAG, "Connecting to VPN with config path: $configPath")
                    startVpnWithConfig(configPath)
                }else {
                    Log.w(TAG, "No config path provided")
                    stopVpn()
                }
            }
            ACTION_DISCONNECT_VPN -> {
                Log.i(TAG, "Disconnecting from VPN")
                stopVpn()
            }else->{
                Log.w(TAG, "Unknown action: ${intent?.action}")
            }
        }
        return START_STICKY

    }
    private fun startVpnWithConfig(configPath: String) {
        Log.d(TAG, "startVpnWithConfig.ConfigPath=$configPath")
        println("VpnService.startVpnWithConfig.ConfigPath=$configPath")
    }
        private fun stopVpn() {
            Log.d(TAG, "stopVpn")
            try {
                vpnInterface?.close()
                Log.d(TAG, "VPN connection closed")
            }catch (e: Exception){
                Log.e(TAG, "Error closing VPN connection", e)}
            vpnInterface=null
            stopSelf()
            Log.d(TAG, "VpnService stopped")
        }
        override fun onDestroy() {

            Log.d(TAG, "onDestroy")
            if (vpnInterface !=null){
                stopVpn()
            }
            super.onDestroy()
        }
        override fun onRebind(intent: Intent?) {
            Log.d(TAG, "onRebind")
            super.onRebind(intent)
        }
        override fun onUnbind(intent: Intent?): Boolean {
            Log.d(TAG, "onUnbind")
            return super.onUnbind(intent)
        }
        override fun onCreate() {
            Log.d(TAG, "onCreate")
            super.onCreate()
        }









}