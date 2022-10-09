package com.example.homework4

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.create_account.*

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.create_account)
        btn_createacc.setOnClickListener {
            var firstname=et_firstname.text.toString()
            var lastname = et_lastname.text.toString()
            var email = et_email.text.toString()
            var password = et_password.text.toString()
            if (firstname.length>0 && lastname.length>0 && email.length>0 && password.length>0) {
                val user = User(firstname, lastname, email, password)
                val intent = Intent(this, MainActivity::class.java)
                intent.putExtra("user", user)
                startActivity(intent)
            }else{
                Toast.makeText(this, "All the fields are mandatory", Toast.LENGTH_LONG).show()
            }
        }

    }
}