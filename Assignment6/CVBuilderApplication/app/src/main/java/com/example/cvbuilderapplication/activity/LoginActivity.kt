package com.example.cvbuilderapplication.activity

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.cvbuilderapplication.R
import com.example.cvbuilderapplication.databinding.ActivityLoginBinding
import com.example.cvbuilderapplication.helper.AppUtils

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    private lateinit var sharedPref : SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        sharedPref = AppUtils.setPref(this)
        val prefEmail = AppUtils.getPref(getString(R.string.login_email_key))
        val prefPassword = AppUtils.getPref(getString(R.string.login_password_key))
        prefEmail?.let { binding.etEmail.setText(it) }
        prefPassword?.let { binding.etPassword.setText(it) }
        val theme = AppUtils.getPref(getString(R.string.saved_theme))
        if (theme != null) AppUtils.decideTheme(theme)
    }

    fun login(view: View) {
        val user = binding.etEmail.text.toString().trim()
        val pass = binding.etPassword.text.toString().trim()

        if(user.isEmpty() && pass.isEmpty()){
            Toast.makeText(applicationContext,"Please enter email and password", Toast.LENGTH_LONG).show()
            return
        }
        if(user.isEmpty()){
            Toast.makeText(applicationContext,"Please enter email", Toast.LENGTH_LONG).show()
            return
        }
        if(pass.isEmpty()){
            Toast.makeText(applicationContext,"Please enter password", Toast.LENGTH_LONG).show()
            return
        }
        openMainActivity(user, pass)
    }

    private fun openMainActivity(user: String, pass: String){
        with(sharedPref.edit()) {
            putString(getString(R.string.login_email_key), user)
            putString(getString(R.string.login_password_key), pass)
            apply()
        }
        startActivity(Intent(this, MainActivity::class.java))
    }
}