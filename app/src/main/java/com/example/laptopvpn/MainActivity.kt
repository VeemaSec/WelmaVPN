package com.example.laptopvpn

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
        override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

            //val stopstartvpn = StopStartVpn()
            lateinit var connectButton: Button
            connectButton = findViewById(R.id.btnConnect)


            fun VpnService() {
                val intent = Intent(this, StopStartVpn::class.java)
                startService(intent)
            }

            connectButton.setOnClickListener {
                VpnService()
                Toast.makeText(this, "VPN Connected!", Toast.LENGTH_SHORT).show()
            }


}
} //Remove brackets if wanting to use code below
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
//            .addAddress("192.168.2.2", 24)
//            .addRoute("0.0.0.0", 0)
//            .addDnsServer("0.0.0.0")
//            .establish()
        //
    //}
    //}
//}
