package com.example.laptopvpn

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class SubscriptionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_subscription)

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
        //SubscriptionPage Content Functions
        //////////////////////////////////
        //Come here!

    }
}