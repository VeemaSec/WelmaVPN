package com.example.laptopvpn

import android.content.Intent
import android.net.VpnService
import android.os.ParcelFileDescriptor
import java.io.FileInputStream
import java.io.FileOutputStream


//Another way I tried to make VPN function work - tested with making changes to Manifest
// and by calling this instead of StopStartVPN in MainActivity
class VPNfunction : VpnService() {

    private var vpnInterface: ParcelFileDescriptor? = null
    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        startVpn()
        return START_STICKY
    }

    private fun startVpn() {
        val VpnService = VpnService()
        VpnService.apply {
            val builder = Builder()
            builder.addAddress("184.178.172.18", 32)
            builder.addRoute("0.0.0.0", 0)
            vpnInterface = builder.establish()
        }

        val vpnInput = FileInputStream(vpnInterface?.fileDescriptor)
        val vpnOutput = FileOutputStream(vpnInterface?.fileDescriptor)

        val buffer = ByteArray(4096)
        while(true) {
            val readLength = vpnInput.read(buffer)
            if(readLength > 0) {
                //Handling VPN data
                vpnOutput.write(buffer, 0, readLength)

            }
        }

    }

}