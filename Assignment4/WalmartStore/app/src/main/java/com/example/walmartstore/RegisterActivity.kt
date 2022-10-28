package com.example.walmartstore

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
    }

    fun createUser(view : View){
        val firstName  = etUserFirstName.text.toString().trim();
        val lastName = etUserLastName.text.toString().trim()
        val emailAddress= etUserEmailAddress.text.toString().trim()
        val password = etUserPassword.text.toString().trim()

        if(firstName.isEmpty() || lastName.isEmpty() || emailAddress.isEmpty() || password.isEmpty()){
            Toast.makeText(applicationContext,"Please fill all required fields", Toast.LENGTH_LONG).show()
        }
        else{
            val user = User(firstName, lastName, emailAddress, password)
            Toast.makeText(applicationContext, "Account created successfully", Toast.LENGTH_LONG)
                .show()

            etUserFirstName.text.clear()
            etUserLastName.text.clear()
            etUserEmailAddress.text.clear()
            etUserPassword.text.clear()

            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("user", user)
            startActivity(intent)
        }
    }
}