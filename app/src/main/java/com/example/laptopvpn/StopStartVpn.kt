package com.example.laptopvpn

import android.content.Intent
import android.net.VpnService
import android.os.ParcelFileDescriptor
import java.io.FileInputStream
import java.io.FileOutputStream
import java.net.InetSocketAddress
import java.nio.ByteBuffer
import java.nio.channels.DatagramChannel

class StopStartVpn : VpnService() {
    private var parcelFileDescriptor: ParcelFileDescriptor? = null
    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Thread{
            try{
                parcelFileDescriptor = establishVpn()
                startVpnConnection(parcelFileDescriptor!!)
            } catch (e: Exception){
                e.printStackTrace()
            }
        }.start()
        return START_STICKY
        //return super.onStartCommand(intent, flags, startId)
    }

    override fun onDestroy() {
        parcelFileDescriptor?.close()
        super.onDestroy()
    }

    private fun establishVpn(): ParcelFileDescriptor?{
        val builder = Builder()
        builder.addAddress("180.000.000.001",32)
        builder.addRoute("0.0.0.0",0)
        return builder.establish()
    }

    private fun startVpnConnection(parcelFileDescriptor: ParcelFileDescriptor){
        val byteBuffer = ByteBuffer.allocate(1500)
        val fileInputStream = FileInputStream(parcelFileDescriptor.fileDescriptor)
        val fileOutputStream = FileOutputStream(parcelFileDescriptor.fileDescriptor)
        val datagramChannel = DatagramChannel.open()
        datagramChannel.socket().bind(InetSocketAddress(0))
        datagramChannel.connect(InetSocketAddress("180.00.000.001",1080))

        while(true){
            byteBuffer.clear()
            val length = fileInputStream.channel.read(byteBuffer)
            if(length > 0){
                byteBuffer.flip()
                datagramChannel.write(byteBuffer)
            }

            byteBuffer.clear()
            val recv = datagramChannel.read(byteBuffer)
            if(recv > 0){
                byteBuffer.flip()
                fileOutputStream.channel.write(byteBuffer)
            }
        }
    }
}