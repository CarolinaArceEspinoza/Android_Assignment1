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

    //Declare Binding Var (object)
    private lateinit var binding: ActivitySignUpBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        //initial  values for the created binding object:
        binding = ActivitySignUpBinding.inflate(layoutInflater) //access to my components
        setContentView(binding.root)

        binding.btnCreateAccount.setOnClickListener {
            val username = binding.txtUsername.text.toString()
            val password = binding.txtPassword.text.toString()
            val confirmPassword = binding.txtConfirmPassword.text.toString()

            // text we get from the user are "editable" datatype
            // we convert them to strings for comparison later (compare this)
            // value to a value in a database (string)

            // check if the password match:
            if (password != confirmPassword){
                Toast.makeText(this, "Password do not match", Toast.LENGTH_SHORT).show()
            }
            else {
                val sharedPreferences: SharedPreferences = getSharedPreferences("UserPref", MODE_PRIVATE)
                val editor : SharedPreferences.Editor = sharedPreferences.edit()

                editor.putString("USERNAME", username)
                editor.putString("PASSWORD", password)
                editor.apply()

                Toast.makeText(this, "Account Created!", Toast.LENGTH_SHORT).show()

                val intent = Intent(this, Login::class.java)
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