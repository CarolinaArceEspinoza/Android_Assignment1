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

    //Declare Binding Var (object)
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        //initial  values for the created binding object:
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // navigate to the sign up page:
        binding.btnSignUp.setOnClickListener {
            // set an order to the sign up page to open (intent). To do it first we create the intent then send
            val intent = Intent(this,SignUp::class.java)
            startActivity(intent)
        }

        // navigate to the sign up 2 page:
        binding.btnSignUp2.setOnClickListener {
            // set an order to the sign up page to open (intent). To do it first we create the intent then send
            val intent = Intent(this,SignUp2::class.java)
            startActivity(intent)
        }

        // navigate to the login page
        binding.btnLogin.setOnClickListener {
            val intent = Intent(this, Login::class.java)
            startActivity(intent)
        }

        // navigate to the login 2 page
        binding.btnLogin2.setOnClickListener {
            val intent = Intent(this, Login2::class.java)
            startActivity(intent)
        }

        // navigate to the Updates Link
        binding.btnUpdates.setOnClickListener {
            // intent to go to URL, using uri (if we want our code to access any information it will access in the form URI)
            // we want to access URL (link), we will give the link in the form of URI
            val updatesUrl = "https://github.blog/changelog/"
            // now create the order (intent)
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(updatesUrl))
            // start the activity created in the previous line
            startActivity(intent)
        }


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}