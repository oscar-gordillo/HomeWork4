package com.example.homework4

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val list = arrayListOf(User("Joe","Dow","joe@gmail.com","123456")
                          ,User("Helen","Rich","helen@gmail.com","123456")
                          ,User("Pedro","Perez","pedro@gmail.com","123456")
                          ,User("Juan","Gomez","juan@gmail.com","123456")
                          ,User("John","Biden","john@gmail.com","123456")
                           )
    lateinit var result: User

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val temp = intent.getSerializableExtra("user")
        if (temp!=null) {
            result = temp as User
            list.add(result)
            Toast.makeText(this, "Account created successfully ${list.size}", Toast.LENGTH_LONG).show()
        }

        btn_signin.setOnClickListener {
            var found=false
            for (user in list) {
                if (user.username.equals(et_email.text.toString())) {
                    if (user.password.equals(et_password.text.toString())) {
                        found=true
                        break
                    }
                }
            }
            if (found) {
                //Toast.makeText(this, "Found", Toast.LENGTH_LONG).show()
                val intent = Intent(this, CategoryActivity::class.java)
                intent.putExtra("username",et_email.text.toString()) // Here message is a key to retrieve the input text in the second activity
                startActivity(intent)
            }else{
                Toast.makeText(this, "Username Not Found or wrong password", Toast.LENGTH_LONG).show()
            }
        }
        btn_register.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }
        tv_forgot.setOnClickListener {
            val mail = et_email.text.toString()
            if (mail.length==0) {
                Toast.makeText(this, "Fill the email to send the password", Toast.LENGTH_LONG).show()
            }else{


                var found=false
                var password=""
                for (user in list) {
                    if (user.username.equals(mail)) {
                        password=user.password
                        found=true
                        break
                    }
                }
                if (found) {
                    val intent = Intent()
                    intent.data= Uri.parse("mailto:$mail?subject=Password&body=$password")
                    intent.action = Intent.ACTION_SENDTO
                    //intent.type = "text/plain"
                    intent.putExtra(Intent.EXTRA_TEXT, password)
                    intent.putExtra(Intent.EXTRA_SUBJECT, "Forgot Password?");
                    intent.putExtra(Intent.EXTRA_EMAIL, mail)
                    startActivity(intent)
                }else {
                    Toast.makeText(this, "The e-mail is not registered", Toast.LENGTH_LONG).show()
                }

            }
        }
    }
}