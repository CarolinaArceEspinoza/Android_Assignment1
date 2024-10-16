package com.example.activityweek6

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.content.Intent
import android.net.Uri
import com.example.activityweek6.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    // Declare a variable to hold the view binding object.
    // The binding object allows access to all the views in the layout.
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Enable edge-to-edge display, allowing app content to extend behind system bars like status and navigation bars.
        enableEdgeToEdge()

        // Initialize the binding object. It inflates (creates) the layout views and binds them to this activity.
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root) // Set the activity's content to the layout bound by the binding object.

        // Set up the action for the "Sign Up" button to navigate to the SignUp activity.
        binding.btnSignUp.setOnClickListener {
            // set an order to the sign up page to open (intent). To do it first we create the intent then send
            val intent = Intent(this,SignUp::class.java)
            startActivity(intent)// Start the SignUp activity.
        }

        // Set up the action for the "Sign Up 2" button to navigate to the SignUp2 activity.
        binding.btnSignUp2.setOnClickListener {
            // set an order to the sign up page to open (intent). To do it first we create the intent then send
            val intent = Intent(this,SignUp2::class.java)
            startActivity(intent)// Start the SignUp2 activity.
        }

        // Set up the action for the "Login" button to navigate to the Login activity.
        binding.btnLogin.setOnClickListener {
            // set an order to the sign up page to open (intent). To do it first we create the intent then send
            val intent = Intent(this, Login::class.java)
            startActivity(intent) // Start the Login activity.
        }

        // Set up the action for the "Login 2" button to navigate to the Login2 activity.
        binding.btnLogin2.setOnClickListener {
            // set an order to the sign up page to open (intent). To do it first we create the intent then send
            val intent = Intent(this, Login2::class.java)
            startActivity(intent)// Start the Login2 activity.
        }

        // Set up the action for the "Updates" button to navigate to the updates URL in a web browser.
        binding.btnUpdates.setOnClickListener {
            // intent to go to URL, using uri (if we want our code to access any information it will access in the form URI)
            // we want to access URL (link), we will give the link in the form of URI
            val updatesUrl = "https://github.blog/changelog/"
            // now create the order (intent)
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(updatesUrl))
            // start the activity created in the previous line
            startActivity(intent)
        }

        // This is used to handle the display of system bars (like status and navigation bars)
        // and apply appropriate padding to the layout to prevent overlap.
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            // Get the dimensions of system bars (top, bottom, left, right).
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            // Apply padding to the view to ensure it doesn't overlap with system bars.
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets // Return the insets after applying them.
        }
    }
}