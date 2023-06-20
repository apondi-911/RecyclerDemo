package com.example.recyclerdemo.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.example.recyclerdemo.R

class SecondActivity : AppCompatActivity() {

    private lateinit var txvUserMessage:TextView
    private lateinit var btnMoveToNext: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        txvUserMessage = findViewById(R.id.txvUserMessage)
        btnMoveToNext = findViewById(R.id.btnMoveToNext)

        val bundle: Bundle? = intent.extras

        bundle?.let {
            val msg = bundle.getString("message_home")
            Toast.makeText(this,msg,Toast.LENGTH_LONG).show()
            txvUserMessage.text = msg


            btnMoveToNext.setOnClickListener {

                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                Toast.makeText(this, "Button was clicked",Toast.LENGTH_SHORT).show()
            }

        }
    }
}