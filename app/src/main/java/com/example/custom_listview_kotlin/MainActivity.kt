package com.example.custom_listview_kotlin

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.custom_listview_kotlin.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    private lateinit var userArrayList : ArrayList<User>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val imageId = intArrayOf(

            R.drawable.a,R.drawable.b,R.drawable.c,R.drawable.d,R.drawable.e,
            R.drawable.f,R.drawable.g,R.drawable.h,R.drawable.i

        )

        val name = arrayOf(

            "Christopher",
            "Craig",
            "Sergio",
            "Mubariz",
            "Mike",
            "Ivana",
            "Toa",
            "Michael",
            "Alex"
        )

        val lastMessage = arrayOf(

            "Heye","Supp","Let's Catchup","Dinner tonight?","Gotta go",
            "i'm in meeting","Gotcha","Let's Go","any Weekend Plans?"

        )

        val lastmsgTime = arrayOf(

            "8:45 pm","9:00 am","7:34 pm","6:32 am","5:76 am",
            "5:00 am","7:34 pm","2:32 am","7:76 am"


        )

        val phoneNo = arrayOf(

            "7656610000","9999043232","7834354323","9876543211","5434432343",
            "9439043232","7534354323","6545543211","7654432343"

        )

        val country = arrayOf(
            "United States","Russia","India","Israel","Germany","Thailand","Canada","France","Switzerland"

        )

        userArrayList = ArrayList()

        for( i in name.indices){

            val user = User(name[i],lastMessage[i],lastmsgTime[i],phoneNo[i],country[i],imageId[i])
            userArrayList.add(user)

        }

        binding.listview.isClickable = true
        binding.listview.adapter = MyAdapter(this,userArrayList)
        binding.listview.setOnItemClickListener { parent, view, position, id ->

            val name = name[position]
            val phone = phoneNo[position]
            val country = country[position]
            val imageId = imageId[position]

            val i = Intent(this,UserActivity::class.java)
            i.putExtra("name",name)
            i.putExtra("phone",phone)
            i.putExtra("country",country)
            i.putExtra("imageId",imageId)
            startActivity(i)


        }

    }
}