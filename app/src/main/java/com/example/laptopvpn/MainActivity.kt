package com.example.laptopvpn

import android.content.Intent
import android.content.pm.PackageManager
import android.net.VpnService
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ReportFragment.Companion.reportFragment
import java.net.DatagramSocket
import java.net.Socket


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // Lateinits
        lateinit var btnStartVPN: Button
        lateinit var btnStopVPN: Button

        // The apps that will have access to the VPN.
        val appPackages = arrayOf(
            "com.android.chrome",
            "com.google.android.youtube",
            "com.example.a.missing.app")

// Loop through the app packages in the array and confirm that the app is
// installed before adding the app to the allowed list.
        val builder = VpnService.Builder()
        for (appPackage in appPackages) {
            try {
                packageManager.getPackageInfo(appPackage, 0)
                builder.addAllowedApplication(appPackage)
            } catch (e: PackageManager.NameNotFoundException) {
                // The app isn't installed.
            }
        }

        // Create a local TUN interface using predetermined addresses. In your app,
        // you typically use values returned from the VPN gateway during handshaking.
        val localTunnel = builder
            .addAddress("192.168.2.2", 24)
            .addRoute("0.0.0.0", 0)
            .addDnsServer("192.168.1.1")
            .establish()

        //Ask user permission
        VpnService.prepare(localTunnel)

            //Start VPN BUTTON
            btnStartVPN.setOnClickListener {
                val intent = Intent(this, DatagramSocket::class.java)
                startService(intent)

                //SOCKETTI TÄNNE!!
                val Socket socket = val new Socket();
                val Socket.bind(localTunnel)

                VPNService.protect(DatagramSocket)
                DatagramSocket.connect()


   //             if((null != socket) && (null != VPNService)) {
   //                 VPNService.protect(socket);
   //             }
   //             DatagramSocket.setDatagramSocketImplFactory(localTunnel);
   //         }


        //Stop VPN BUTTON
        btnStopVPN.setOnClickListener {
            DatagramSocket.close(null)

        }

        //
    }
}
