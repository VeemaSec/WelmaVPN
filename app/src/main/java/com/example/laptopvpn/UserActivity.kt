package com.example.laptopvpn

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class UserActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_user)

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
        //UserPage Content Functions
        //////////////////////////////////
        //Come here!
    }
}