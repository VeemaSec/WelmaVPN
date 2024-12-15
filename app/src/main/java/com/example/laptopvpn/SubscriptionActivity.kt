package com.example.laptopvpn

import android.content.Intent
import android.os.Bundle
import android.widget.Button
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
    //SubscriptionPage Content Functions
    //////////////////////////////////
        var subscriptionTime = 0

        //SettingUp Payment Buttons
        var btnBuy1: Button = findViewById(R.id.btnBuy1)
        var btnBuy2: Button = findViewById(R.id.btnBuy2)
        var btnBuy3: Button = findViewById(R.id.btnBuy3)

        //OnClickListeners to pre-defined Payment Options
        btnBuy1.setOnClickListener {
            subscriptionTime += 30
        }
        btnBuy2.setOnClickListener {
            subscriptionTime += 180
        }
        btnBuy3.setOnClickListener {
            subscriptionTime += 365
        }

        //Needs to Return The Updated 'subscriptionTime' -value to Cloud FireStore

        }
    }


