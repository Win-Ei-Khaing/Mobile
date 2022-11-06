package com.example.walmartstore

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.graphics.drawable.toDrawable
import com.example.walmartstore.data.Product
import kotlinx.android.synthetic.main.activity_electronics_detail.*

class ElectronicsDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_electronics_detail)

        val product: Product? = intent.getSerializableExtra("product") as Product?
        product?.image?.let { detail_product_image.setBackgroundResource(it) }
        detail_product_title.text = product?.title
        detail_product_color.text = "Color: ${product?.color}"
        detail_product_number.text = "Walmart #: ${product?.itemId.toString()}"
        detail_product_description.text = "Item Description:\n${product?.desc}"
    }
}