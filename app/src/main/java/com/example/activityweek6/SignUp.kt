package com.example.activityweek6
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.activityweek6.databinding.ActivitySignUpBinding

class SignUp : AppCompatActivity() {

    // Declare a variable to hold the view binding object.
    // The binding object allows access to all the views in the layout.
    private lateinit var binding: ActivitySignUpBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        // Initialize the binding object. It inflates (creates) the layout views and binds them to this activity.
        binding = ActivitySignUpBinding.inflate(layoutInflater) //access to my components
        setContentView(binding.root) // Set the activity's content to the layout bound by the binding object.

        // Set up the action for the "Create Account" button when clicked.
        binding.btnCreateAccount.setOnClickListener {
            // Get the text entered by the user in the username, password, and confirm password fields.
            val username = binding.txtUsername.text.toString()
            val password = binding.txtPassword.text.toString()
            val confirmPassword = binding.txtConfirmPassword.text.toString()

            // The input values from the user are of type "editable".
            // We convert them to strings for comparison purposes later.

            // Check if the entered password matches the confirmed password.
            if (password != confirmPassword){
                // If they don't match, display a message indicating the mismatch.
                Toast.makeText(this, "Password do not match", Toast.LENGTH_SHORT).show()
            }
            else {
                // If the passwords match, save the username and password using SharedPreferences.
                val sharedPreferences: SharedPreferences = getSharedPreferences("UserPref", MODE_PRIVATE)
                val editor : SharedPreferences.Editor = sharedPreferences.edit()

                // Store the username and password in SharedPreferences.
                editor.putString("USERNAME", username)
                editor.putString("PASSWORD", password)
                editor.apply()  // Apply changes to save the data.

                // Show a message indicating that the account was created successfully.
                Toast.makeText(this, "Account Created!", Toast.LENGTH_SHORT).show()

                // Create an Intent to navigate to the Login activity after account creation.
                val intent = Intent(this, Login::class.java)
                startActivity(intent) // Start the Login activity.
            }
        }

        // Set up the action for the "Back to Main" button when clicked.
        binding.btnBackToMain.setOnClickListener {
            // Create an Intent to navigate back to the MainActivity.
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent) // Start the MainActivity.
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}