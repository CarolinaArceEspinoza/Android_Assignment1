package com.example.activityweek6

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.activityweek6.databinding.ActivitySignUp2Binding

class SignUp2 : AppCompatActivity() {
    //Declare Binding Var (object)
    private lateinit var binding: ActivitySignUp2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        //initial  values for the created binding object:
        binding = ActivitySignUp2Binding.inflate(layoutInflater) //access to my components
        setContentView(binding.root)

        binding.btnCreateAccount2.setOnClickListener {
            val email = binding.txtEmail.text.toString()
            val password = binding.txtPassword.text.toString()
            val confirmPassword = binding.txtConfirmPassword.text.toString()
            val emailPattern = Regex("^[a-zA-Z0-9_.±]+@[a-zA-Z0-9-]+.[a-zA-Z0-9-.]+\$")
            val passwordPattern = Regex("^(?=.*[a-z])(?=.*[A-Z])(?=.*[@\$!_%*?&\\-])[A-Za-z\\d@\$!_%*?&\\-]{8,15}\$")

            // check if the password match:
            if (password != confirmPassword){
                Toast.makeText(this, "Password do not match", Toast.LENGTH_SHORT).show()
            } else if (!password.matches(passwordPattern)){
                Toast.makeText(this, "password debe contener x", Toast.LENGTH_SHORT).show()
            } else if (!email.matches(emailPattern)){
                Toast.makeText(this, "E-mail incorrect", Toast.LENGTH_SHORT).show()
            } else {
                val sharedPreferences: SharedPreferences = getSharedPreferences("UserPref", MODE_PRIVATE)
                val editor : SharedPreferences.Editor = sharedPreferences.edit()

                editor.putString("EMAIL", email)
                editor.putString("PASSWORD", password)
                editor.apply()

                Toast.makeText(this, "Account Created!", Toast.LENGTH_SHORT).show()

                val intent = Intent(this, Login2::class.java)
                startActivity(intent)

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