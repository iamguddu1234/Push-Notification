package com.example.databindingexamples

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.messaging.FirebaseMessaging

class MainActivity : AppCompatActivity() {

    companion object {
        private const val TAG = "MainActivity"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        FirebaseMessaging.getInstance().token.addOnCompleteListener { task ->
            if (task.isSuccessful) {
                val token = task.result
                // Log the token
                Log.d(TAG, "FCM Token: $token")

                // Toast the token
                Toast.makeText(this, "FCM Token: $token", Toast.LENGTH_LONG).show()

                sendTokenToServer(token)
            } else {
                // Handle the error
                Toast.makeText(this, "Failed to get FCM token", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun sendTokenToServer(token: String?) {
        // Implement this method to send the token to your app server
    }
}
