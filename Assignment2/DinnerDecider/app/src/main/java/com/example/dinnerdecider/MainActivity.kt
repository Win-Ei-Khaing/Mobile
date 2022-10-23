package com.example.dinnerdecider

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlin.random.Random
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    var foodList = arrayListOf<String>("Hamburger", "Pizza", "Mexican", "American", "Chinese")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        etNewFoodName.clearFocus()
    }

    fun decide(view: View) {
        etNewFoodName.clearFocus()
        val randIdx = Random.nextInt(foodList.size)
        tvFoodName.text = foodList[randIdx]
    }

    fun addFood(view: View){
        val newFood = etNewFoodName.text.toString().trim()
        if (newFood.isNotEmpty()) {
            tvFoodName.text = newFood
            if(!foodList.contains(newFood))
                foodList.add(newFood)
        }
        etNewFoodName.text.clear()
    }
}