package com.example.walmartstore

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_register.*

class MainActivity : AppCompatActivity() {
    private var users = mutableListOf(
        User("Win", "Win", "wineikhaing111111@gmail.com", "12345"),
        User("Ei", "Ei", "ei@gmail.com", "12345"),
        User("Ella", "Ella", "ella@gmail.com", "12345"),
        User("Wee", "Wee", "thae@gmail.com", "12345"),
        User("Su", "Su", "su@gmail.com", "12345")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        etUserName.requestFocus()

        val user: User? = intent.getSerializableExtra("user") as User?
        user?.let { users.add(user) }

        //Toast.makeText(this, "Added  ${user?.firstname}! Users count : "+users.count(), Toast.LENGTH_SHORT).show()
    }

    fun signIn(view: View) {
        val email = etUserName.text.toString().trim()
        val pass = etPassword.text.toString().trim()
        if(email.isEmpty()){
            Toast.makeText(this,"Please enter your email", Toast.LENGTH_LONG).show()
            return
        }
        if(pass.isEmpty()){
            Toast.makeText(this,"Please enter your password", Toast.LENGTH_LONG).show()
            return
        }

        var correctUser = false
        for(user in users){
            if(user.username == email && user.password == pass){
                correctUser = true
                val intent = Intent(this, ShoppingCategoryActivity::class.java)
                intent.putExtra("user", user)
                startActivity(intent)
            }
        }
        if(!correctUser){
            Toast.makeText(this,"Invalid username and password.", Toast.LENGTH_LONG).show()
        }
    }

    fun goToRegisterActivity(view: View){
        startActivity(Intent(this, RegisterActivity::class.java))
    }

    fun sendStoredPassword(view: View) {
        val email = etUserName.text.toString().trim()
        if(email.isEmpty())
            Toast.makeText(this, "Please enter your email", Toast.LENGTH_SHORT).show()
        else {
                var correctUser: User? = null
                for(user in users){
                    if(user.username == email)
                        correctUser = user
                }
                if(correctUser==null)
                        Toast.makeText(this, "Invalid email", Toast.LENGTH_SHORT).show()
                else{
                    val intent = Intent(Intent.ACTION_SENDTO)
                    intent.data = Uri.parse("mailto:")
                    intent.putExtra(Intent.EXTRA_EMAIL, email)
                    intent.putExtra(Intent.EXTRA_SUBJECT, "Sending password to restore")
                    intent.putExtra(Intent.EXTRA_TEXT, "Here is the stored password : " + correctUser?.password);
                    if (intent.resolveActivity(packageManager) != null) {
                            startActivity(intent)
                    }
                    else
                        Toast.makeText(this, "No mail service is available on this device", Toast.LENGTH_SHORT).show()
                }
            }
    }
}