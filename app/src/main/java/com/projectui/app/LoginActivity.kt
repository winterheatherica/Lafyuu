package com.projectui.app

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val emailEditText: EditText = findViewById(R.id.EmailForm)
        val passwordEditText: EditText = findViewById(R.id.PasswordForm)
        val signInButton: Button = findViewById(R.id.BTNSignIn)
        val loginGoogleButton: Button = findViewById(R.id.BTNSignInGoogle)
        val loginFacebookButton: Button = findViewById(R.id.BTNSignInFacebook)
        val forgotPasswordTextView: TextView = findViewById(R.id.txtForgotPassword)
        val registerTextView: TextView = findViewById(R.id.Register)

        signInButton.setOnClickListener {
            val email = emailEditText.text.toString().trim()
            val password = passwordEditText.text.toString().trim()

            if (email.isNotEmpty() && password.isNotEmpty()) {
                // Handle login logic here
                if (validateCredentials(email, password)) {
                    Toast.makeText(this, "Logged in successfully", Toast.LENGTH_SHORT).show()
                    val login = Intent(this, HomeActivity::class.java)
                    startActivity(login)
                } else {
                    Toast.makeText(this, "Invalid email or password", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this, "Please enter email and password", Toast.LENGTH_SHORT).show()
            }
        }

        loginGoogleButton.setOnClickListener {
            // Handle Google login logic here
            Toast.makeText(this, "Login with Google", Toast.LENGTH_SHORT).show()
        }

        loginFacebookButton.setOnClickListener {
            // Handle Facebook login logic here
            Toast.makeText(this, "Login with Facebook", Toast.LENGTH_SHORT).show()
        }

        forgotPasswordTextView.setOnClickListener {
            // Handle forgot password logic here
            Toast.makeText(this, "Forgot Password", Toast.LENGTH_SHORT).show()
        }

        registerTextView.setOnClickListener {
            // Handle register logic here
            val register = Intent(this, RegisterActivity::class.java)
            startActivity(register)
        }
    }

    private fun validateCredentials(email: String, password: String): Boolean {
        // This is a placeholder for actual validation logic
        // For example, checking against a database or remote server
        return email == "admin@example.com" && password == "password123"
    }
}
