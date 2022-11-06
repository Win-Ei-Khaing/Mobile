package com.example.walmartstore

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.walmartstore.data.Product
import com.example.walmartstore.data.User
import kotlinx.android.synthetic.main.activity_shopping_category.*

class ShoppingCategoryActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shopping_category)

        val user: User? = intent.getSerializableExtra("user") as User?
        tvWelcomeText.text = "Welcome: ${user?.username}"
    }

    fun ivClick(view: View){
        when (view.id) {
            R.id.ivElectronics -> {
                //Toast.makeText(this, "You have chosen the Electronics category of shopping", Toast.LENGTH_LONG).show()
                startActivity(Intent(this, ElectronicsCategoryActivity::class.java))
            }
            R.id.ivClothing -> {
                Toast.makeText(this, "You have chosen the Clothing category of shopping", Toast.LENGTH_LONG).show()
            }
            R.id.ivBeauty -> {
                Toast.makeText(this, "You have chosen the Beauty category of shopping", Toast.LENGTH_LONG).show()
            }
            R.id.ivFood -> {
                Toast.makeText(this, "You have chosen the Food category of shopping", Toast.LENGTH_LONG).show()
            }
        }
    }
}