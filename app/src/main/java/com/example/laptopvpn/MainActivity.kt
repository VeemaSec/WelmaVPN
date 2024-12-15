package com.example.laptopvpn

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    @SuppressLint("SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // ViewBindings

        ////////////////////////////////
        //NAVIGATION For LoggedIn Users
        var btnConnection: ImageButton = findViewById(R.id.btnConnection)
        var btnUser: ImageButton = findViewById(R.id.btnUser)
        var btnSubsciption: ImageButton = findViewById(R.id.btnSubsciption)
        var btnSettings: ImageButton = findViewById(R.id.btnSettings)

            // OnClickListeners for Navigation
            btnConnection.setOnClickListener {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }

            btnUser.setOnClickListener {
                val intent = Intent(this, UserActivity::class.java)
                startActivity(intent)
            }

            btnSubsciption.setOnClickListener {
                val intent = Intent(this, SubscriptionActivity::class.java)
                startActivity(intent)
            }

            btnSettings.setOnClickListener {
                val intent = Intent(this, SettingsActivity::class.java)
                startActivity(intent)
            }


        ///////////////////////////////////
        //ConnectionPage Content Functions
        //////////////////////////////////
        //val stopstartvpn = StopStartVpn()
        var connectButton: Button = findViewById(R.id.btnConnect)

            fun VpnService() {
                val intent = Intent(this, StopStartVpn::class.java)
                startService(intent)
            }

            //Connect to Service
            connectButton.setOnClickListener {
                VpnService()
                Toast.makeText(this, "VPN Connected!", Toast.LENGTH_SHORT).show()
            }

}
}//
////////////////////////////////////////////////////////////////////////////////

        // Lateinits
//        lateinit var btnStartVPN: Button
//        lateinit var btnStopVPN: Button

        // The apps that will have access to VPN
//        val appPackages = arrayOf(
//            "com.android.chrome",
//            "com.google.android.youtube",
//            "com.example.a.missing.app")

// Loop through the app packages in the array and confirm that the app is
// installed before adding the app to the allowed list.
//        val builder = Builder()
//        for (appPackage in appPackages) {
//            try {
//                packageManager.getPackageInfo(appPackage, 0)
//                builder.addAllowedApplication(appPackage)

//            } catch (e: PackageManager.NameNotFoundException) {
//                // The app isn't installed.
//            }
//        }

        // Create a local TUN interface using predetermined addresses
//        val localTunnel = builder
//            .addAddress("192.0.0.1", 24)
//            .addRoute("0.0.0.0", 0)
//            .addDnsServer("0.0.0.0")
//            .establish()
        //
    //}
    //}
//}
