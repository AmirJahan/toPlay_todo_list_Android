package com.oddinstitute.toplay

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.KeyEvent
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.oddinstitute.toplay.model.Task

class TasksActivity : AppCompatActivity(),
                      TaskClickListener
{
    override fun rowClicked(index: Int)
    {
        //        thisCategory.tasks[index].isDone = !thisCategory.tasks[index].isDone

        AppData.categories[catIndex].tasks[index].isDone =
            !AppData.categories[catIndex].tasks[index].isDone

        tasksAdapter.notifyItemChanged(index)



    }

    override fun rowLongClicked(index: Int)
    {
        // delete the row and the task

        AppData.categories[catIndex].tasks.removeAt(index)
        tasksAdapter.notifyItemRemoved(index)


    }


    lateinit var tasksRecyclerView: RecyclerView
    // lateinit var thisCategory: Category

    lateinit var tasksAdapter: TasksAdapter


    var catIndex = 0
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tasks)


        catIndex = intent.getIntExtra("categoryIndex", 0)
        // thisCategory = AppData.categories[index]

        tasksRecyclerView = findViewById(R.id.tasksRecyclerView_id)
        tasksRecyclerView.layoutManager = LinearLayoutManager(this)

        tasksAdapter = TasksAdapter(catIndex, this)
        tasksRecyclerView.adapter = tasksAdapter


        val nameEditText = findViewById<EditText>(R.id.newTaskEditText_id)


        nameEditText.setOnKeyListener { view, keyCode, event ->

            if (keyCode == KeyEvent.KEYCODE_ENTER)
            {
                if (event.action == KeyEvent.ACTION_UP)
                {
                    val task = Task(nameEditText.text.toString())
                    AppData.categories[catIndex].tasks.add(task)

                    tasksAdapter.notifyItemInserted(AppData.categories[catIndex].tasks.count())

                    nameEditText.text.clear()


                    val inputManager = getSystemService(Activity.INPUT_METHOD_SERVICE)
                            as InputMethodManager

                    inputManager.hideSoftInputFromWindow(view.windowToken, 0)


                }

            }

            false
        }

    }
}