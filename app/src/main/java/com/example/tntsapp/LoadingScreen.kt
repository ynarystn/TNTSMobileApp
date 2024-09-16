package com.example.tntsapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

class LoadingScreen : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_loading_screen)

        val progressBar = findViewById<ProgressBar>(R.id.progress_bar)
        val btnGetStarted = findViewById<Button>(R.id.btn_get_started)

        Handler(Looper.getMainLooper()).postDelayed({
            progressBar.visibility = View.GONE
            btnGetStarted.visibility = View.VISIBLE

            btnGetStarted.setOnClickListener {
                showContinueWithGoogleDialog()
            }
        }, 2000)  // Delay of 2 seconds

    }

    // Method to show the dialog when "Get Started" is clicked
    private fun showContinueWithGoogleDialog() {
        val dialogView = layoutInflater.inflate(R.layout.dialog_continue_with_google, null)
        val dialog = AlertDialog.Builder(this)
            .setView(dialogView)
            .create()

        dialog.window?.setBackgroundDrawableResource(android.R.color.transparent)

        dialogView.findViewById<Button>(R.id.btn_continue_with_google).setOnClickListener {
            dialog.dismiss()

            showWelcomeMessageDialog()
        }

        dialog.show()

    }

    // Function to show the second dialog with the welcome message
    private fun showWelcomeMessageDialog() {
        val welcomeDialogView = layoutInflater.inflate(R.layout.dialog_motivational_message, null)
        val welcomeDialog = AlertDialog.Builder(this)
            .setView(welcomeDialogView)
            .create()

        // Set dialog background to transparent
        welcomeDialog.window?.setBackgroundDrawableResource(android.R.color.transparent)

        welcomeDialogView.findViewById<Button>(R.id.btn_play_video).setOnClickListener {
            // Handle "Play Video" button click here
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            welcomeDialog.dismiss()
        }

        welcomeDialog.show()
    }
}