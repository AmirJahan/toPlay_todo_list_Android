package com.oddinstitute.toplay

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class CategoriesActivity : AppCompatActivity(),
                           CategoryClickListener
{
    override fun rowClicked(index: Int)
    {
        val intent = Intent (this, TasksActivity::class.java)

        intent.putExtra("categoryIndex", index)


        startActivity(intent)

    }

    override fun rowLongClicked(index: Int)
    {
        // listener
    }


    lateinit var categoriesRv: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_categories)

        // this happens just once
        AppData.populateEarlyStuff()



        categoriesRv = findViewById(R.id.categoriesRv_id)
        categoriesRv.layoutManager = LinearLayoutManager (this)

        categoriesRv.adapter = CategoriesAdapter (this)



    }


}