package com.example.walmartstore.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.recyclerview.widget.RecyclerView
import com.example.walmartstore.ElectronicsDetailActivity
import com.example.walmartstore.R
import com.example.walmartstore.data.Product

class CategoryAdapter(val context: Context, val products: MutableList<Product>) :
    RecyclerView.Adapter<BaseViewHolder?>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): BaseViewHolder {
        val itemEvents: View = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.item_list, viewGroup, false)
        return AssignedTasksViewHolder(itemEvents)
    }

    override fun onBindViewHolder(baseViewHolder: BaseViewHolder, i: Int) {
        baseViewHolder.onBind(i)
    }

    override fun getItemCount(): Int = products.size

    inner class AssignedTasksViewHolder(view: View?) : BaseViewHolder(view) {
        var title: TextView? = view?.findViewById(R.id.rv_title)
        var image: ImageView? = view?.findViewById(R.id.rv_image)
        var price: TextView? = view?.findViewById(R.id.rv_price)
        var color: TextView? = view?.findViewById(R.id.rv_color)
        var itemContainer: LinearLayout? = view?.findViewById(R.id.item_container)

        override fun onBind(position: Int) {
            super.onBind(position)
            val product = products[position]

            image?.setBackgroundResource(product.image)
            title?.text = product.title
            price?.text = product.price
            color?.text = product.color

            itemContainer?.setOnClickListener {
                val intent = Intent(context, ElectronicsDetailActivity::class.java)
                var res = products[position]
                intent.putExtra("product",res)
                context.startActivity(intent)
            }
        }
    }
}