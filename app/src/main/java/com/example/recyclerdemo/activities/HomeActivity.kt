package com.example.recyclerdemo.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.recyclerdemo.R


class HomeActivity : AppCompatActivity() {

    companion object {
        val TAG: String = HomeActivity::class.java.simpleName
    }

    private lateinit var btnShowToast: Button
    private lateinit var btnSendMsgToNextActivity:Button
    private lateinit var btnShareToOtherApps: Button
    private lateinit var btnRecyclerViewDemo:Button
    private lateinit var etUserMessage:EditText


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        btnShowToast=findViewById(R.id.btnShowToast)
        btnSendMsgToNextActivity =findViewById(R.id.btnSendMsgToNextActivity)
        btnShareToOtherApps = findViewById(R.id.btnShareToOtherApps)
        btnRecyclerViewDemo = findViewById(R.id.btnRecyclerViewDemo)
        etUserMessage=findViewById(R.id.etUserMessage)


            btnShowToast.setOnClickListener {
                Toast.makeText(this, "Button was clicked",Toast.LENGTH_SHORT).show()
            }

            btnSendMsgToNextActivity.setOnClickListener {
                val message: String = etUserMessage.text.toString()
                val intent = Intent(this, SecondActivity::class.java)

                intent.putExtra("message_home", message)

                startActivity(intent)
            }


            btnShareToOtherApps.setOnClickListener {

                val message: String = etUserMessage.text.toString()

                val intent = Intent()
                intent.action = Intent.ACTION_SEND
                intent.putExtra(Intent.EXTRA_TEXT, message)
                intent.type = "text/plain"

                startActivity(Intent.createChooser(intent, "Please select app: "))
            }

            btnRecyclerViewDemo.setOnClickListener {

                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }
        }

}

