package com.oddinstitute.toplay

import com.oddinstitute.toplay.model.Category
import com.oddinstitute.toplay.model.Task

class AppData
{
    companion object
    {
        var categories: MutableList<Category> = mutableListOf()

        fun populateEarlyStuff ()
        {
            val task1 = Task("Play Call of Duty")
            val task2 = Task("Candy Crush", true)

            val task3 = Task("Fortnight", true)
            val task4 = Task("Battlefield", false)

            val cat1 = Category("School Games", mutableListOf(task1,
                                                              task2,
                                                              task3, task4  ))

            val cat2 = Category("For Fun Games", mutableListOf(task3,
                                                               task4))

            categories = mutableListOf(cat1, cat2)
        }
    }
}