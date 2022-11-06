package com.example.walmartstore

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.walmartstore.data.User
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        btnUserCreate.setOnClickListener {

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

                val intent=intent
                intent.putExtra("user", user)
                setResult(Activity.RESULT_OK, intent)

                etUserFirstName.text.clear()
                etUserLastName.text.clear()
                etUserEmailAddress.text.clear()
                etUserPassword.text.clear()

                finish()
            }
        }
    }
}