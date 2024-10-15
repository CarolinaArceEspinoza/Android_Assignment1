package com.example.activityweek6

import android.content.Intent
import android.content.SharedPreferences
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.activityweek6.databinding.ActivityLogin2Binding
import com.example.activityweek6.databinding.ActivityLoginBinding
import com.example.activityweek6.databinding.ActivitySignUp2Binding

class Login2 : AppCompatActivity() {

    //Declare Binding Var (object)
    private lateinit var binding: ActivityLogin2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        //initial  values for the created binding object:
        binding = ActivityLogin2Binding.inflate(layoutInflater) //access to my components
        setContentView(binding.root)

        // Set up the Login button click listener
        binding.btnLogin.setOnClickListener {
            val username = binding.txtEmail.text.toString()
            val password = binding.txtPassword.text.toString()
            val updatesUrl = "https://github.blog/changelog/"


            // Placeholder: Check if email and password are correct (you can add actual logic here)
            if (username.isNotEmpty() && password.isNotEmpty()) {
                val sharedPreferences: SharedPreferences = getSharedPreferences("UserPref", MODE_PRIVATE)
                val usernameValidation = sharedPreferences.all.get("EMAIL")
                val passwordValidation = sharedPreferences.all.get("PASSWORD")
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(updatesUrl))

                if (username == usernameValidation && password == passwordValidation ) {
                    // start the activity created in the previous line
                    startActivity(intent)
                    Toast.makeText(this, "Login Successful", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this, "Credentials invalid, try again", Toast.LENGTH_SHORT).show()
                }



            } else {
                Toast.makeText(this, "Please enter both email and password", Toast.LENGTH_SHORT).show()
            }


        }






        // go back to the main page using the back button
        binding.btnBackToMain.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}