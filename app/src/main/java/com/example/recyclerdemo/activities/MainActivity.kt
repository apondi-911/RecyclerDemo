package com.example.recyclerdemo.activities


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerdemo.adapters.HobbiesAdapter
import com.example.recyclerdemo.models.HobbiesViewModel
import com.example.recyclerdemo.R

class MainActivity : AppCompatActivity(), HobbiesAdapter.OnItemClickListener {


    private lateinit var rvHobbies: RecyclerView
    private lateinit var btnbackhome: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnbackhome =findViewById(R.id.btnbackhome)
        rvHobbies=findViewById(R.id.recyclerView)

        val layoutManager = LinearLayoutManager(this)
        layoutManager.orientation=LinearLayoutManager.VERTICAL

        rvHobbies.layoutManager=layoutManager

        val adapter = HobbiesAdapter(this, HobbiesViewModel.Supplier.hobbies)
        rvHobbies.adapter= adapter
        adapter.setOnItemClickListener(this)


        btnbackhome.setOnClickListener {

            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
        }

    }

    override fun onItemHobbiesClick(position: Int) {
         Toast.makeText(this,"Hobby",Toast.LENGTH_SHORT).show()
            }

    override fun onItemImageClicked(position: Int) {
        Toast.makeText(this,"Share",Toast.LENGTH_SHORT).show()
    }
}