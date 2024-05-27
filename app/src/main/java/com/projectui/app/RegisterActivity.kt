package com.projectui.app

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class RegisterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        val nameEditText: EditText = findViewById(R.id.NameForm)
        val emailEditText: EditText = findViewById(R.id.EmailForm)
        val passwordEditText: EditText = findViewById(R.id.PasswordForm)
        val confirmPasswordEditText: EditText = findViewById(R.id.PasswordFormConfirm)
        val signUpButton: Button = findViewById(R.id.BTNSignUp)
        val signInTextView: TextView = findViewById(R.id.signin)

        signUpButton.setOnClickListener {
            val name = nameEditText.text.toString().trim()
            val email = emailEditText.text.toString().trim()
            val password = passwordEditText.text.toString().trim()
            val confirmPassword = confirmPasswordEditText.text.toString().trim()

            if (name.isNotEmpty() && email.isNotEmpty() && password.isNotEmpty() && confirmPassword.isNotEmpty()) {
                if (password == confirmPassword) {
                    // Handle sign-up logic here
                    if (registerUser(name, email, password)) {
                        Toast.makeText(this, "Registration successful", Toast.LENGTH_SHORT).show()
                        // Navigate to LoginActivity
                        val intent = Intent(this, LoginActivity::class.java)
                        startActivity(intent)
                        finish()
                    } else {
                        Toast.makeText(this, "Registration failed", Toast.LENGTH_SHORT).show()
                    }
                } else {
                    Toast.makeText(this, "Passwords do not match", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show()
            }
        }

        signInTextView.setOnClickListener {
            // Navigate to LoginActivity
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    private fun registerUser(name: String, email: String, password: String): Boolean {
        // This is a placeholder for actual registration logic
        // For example, saving the user data to a database or remote server
        // Return true if registration is successful, false otherwise
        return true
    }
}
