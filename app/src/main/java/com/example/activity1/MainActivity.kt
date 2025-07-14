package com.example.activity1

import android.app.Activity
import android.content.ContentValues.TAG
import android.content.Intent
import android.net.VpnService
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.activity1.ui.theme.Activity1Theme
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.ui.Alignment

class MainActivity : ComponentActivity() {
    private val TAG = "MainActivity"
    private lateinit var vpnPermissionLauncher: ActivityResultLauncher<Intent>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "Activity created")
        vpnPermissionLauncher = registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()
        ) { result ->
            if (result.resultCode == RESULT_OK) {
                Log.i(TAG, "VPN permission granted")
                startVpnServiceWithConfig()
            } else {
                Log.w(TAG, "VPN permission denied, result code ${result.resultCode}")
                Toast.makeText(this, "VPN permission denied", Toast.LENGTH_LONG).show()

            }
        }
        enableEdgeToEdge()
        setContent {
            Activity1Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    ServiceControlScreen(
                        modifier = Modifier.padding(innerPadding),
                        onStartVpnClick = { checkAndRequestVpnPermission() },
                        onStopVpnClick = { val serviceIntent = Intent(this, MyVpnService::class.java)
                            stopService(serviceIntent) // Use stopService with the intent
                            Log.i(TAG, "Stop VPN service requested")
                            Toast.makeText(this, "VPN service stopping", Toast.LENGTH_SHORT).show() }

                    )
                }
            }
        }
    }


    private fun checkAndRequestVpnPermission() {
        val vpnPrepareIntent = VpnService.prepare(applicationContext)
        if (vpnPrepareIntent != null) {
            Log.i(TAG, "VPN permission not granted, requesting permission")
            Toast.makeText(this, "VPN permission not granted, requesting permission", Toast.LENGTH_SHORT).show()
            try {
                vpnPermissionLauncher.launch(vpnPrepareIntent)
            } catch (e: Exception) {
                Log.e(TAG, "Failed to start VPN permission request activity", e)
                Toast.makeText(this, "Failed to start VPN permission request activity", Toast.LENGTH_LONG).show()
            }
        } else {
            Log.i(TAG, "VPN permission already granted")
            startVpnServiceWithConfig()
        }
    }
    private fun startVpnServiceWithConfig() {
        val simulatedJsonFilePath = "config/deault.json"
        Log.d(TAG,"Starting VPN service with config file $simulatedJsonFilePath")
        val serviceIntent = Intent(this, MyVpnService::class.java).apply{
            action = MyVpnService.ACTION_CONNECT_VPN
            putExtra(MyVpnService.EXTRA_SERVICE_CONFIG_FILE, simulatedJsonFilePath)
        }
        try{
            startService(serviceIntent)
            Log.i(TAG, "VPN service started , $simulatedJsonFilePath")
            Toast.makeText(this, "VPN service started", Toast.LENGTH_SHORT).show()
        }catch (e: Exception){
            Log.e(TAG, "Failed to start VPN service", e)
            Toast.makeText(this, "Failed to start VPN service", Toast.LENGTH_LONG).show()
        }


    }
}

@Composable
fun ServiceControlScreen(
    modifier: Modifier = Modifier,
    onStartVpnClick: () -> Unit,
    onStopVpnClick: () -> Unit

)
{
    val context = LocalContext.current
    //val activity = context as Activity
    //val mainActivity = context as MainActivity

    Column(
        modifier = modifier
        .fillMaxSize()
        .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "VPN Service Control",
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier.padding(bottom = 16.dp)
        )
        Button(
            onClick = { Log.d("ServiceControlScreen", "Button clicked")
                      val serviceIntent = Intent(context, LogService::class.java)
                      context.startService(serviceIntent)
                      Toast.makeText(context, "Service started", Toast.LENGTH_SHORT).show()}){
            Text(text = "Start Service")
        }
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = { Log.d("ServiceControlScreen", "Button clicked")
                val serviceIntent = Intent(context, LogService::class.java)
                context.stopService(serviceIntent)
                Toast.makeText(context, "Service stopped", Toast.LENGTH_SHORT).show()}){
            Text(text = "Stop Service")
        }
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = onStartVpnClick){
            Text(text = "Start VPN")
        }
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = onStopVpnClick){
            Text(text = "Stop VPN")
        }
        Spacer(modifier = Modifier.height(16.dp))
        Greeting(name = "User")
    }

}
@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ServiceControlScreenPreview() {
    Activity1Theme {
        ServiceControlScreen(
            onStartVpnClick = { Log.d("Preview", "Start VPN clicked") },
            onStopVpnClick = { Log.d("Preview", "Stop VPN clicked") }
        )
    }
}
@Composable
fun GreetingPreview() {
    Activity1Theme {
        Greeting("Android")
    }
}