package com.example.laptopvpn

import android.os.Bundle
<<<<<<< Updated upstream
=======
import android.widget.Button
import android.widget.ImageButton
import android.widget.Toast
>>>>>>> Stashed changes
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
<<<<<<< Updated upstream
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}
=======

            ////////////////////////////////
            //NAVIGATION For LoggedIn Users
            lateinit var btnConnection: ImageButton
            lateinit var btnUser: ImageButton
            lateinit var btnSubsciption: ImageButton
            lateinit var btnSettings: ImageButton

            // ViewBindings
            btnConnection = findViewById(R.id.btnConnection)
            btnUser = findViewById(R.id.btnUser)
            btnSubsciption = findViewById(R.id.btnSubsciption)
            btnSettings = findViewById(R.id.btnSettings)

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
            lateinit var connectButton: Button
            connectButton = findViewById(R.id.btnConnect)

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
>>>>>>> Stashed changes
