package com.example.homework4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.categories.*

class CategoryActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.categories)
        val intt = intent // Similar to  Intent intent = getIntent()
        val output = intt.getStringExtra("username")
        tv_welcome.text="welcome $output"
    }
    fun onButtonClick(v: View){
        val clicked = when(v.id){
            (R.id.ib_beauty)->"Beauty"
            (R.id.ib_clothing)->"Clothing"
            (R.id.ib_electronics)->"Electronics"
            (R.id.ib_food)->"Food"
            else -> "NOT FOUND"
        }
        Toast.makeText(this, "You have chosen the $clicked category of shopping", Toast.LENGTH_LONG).show()
    }
}