package com.oddinstitute.toplay

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.oddinstitute.toplay.model.Task




class TasksAdapter (val index: Int,
                   val taskClickListener: TaskClickListener) : RecyclerView.Adapter<TaskViewHolder> ()
{
    override fun getItemCount(): Int = AppData.categories[index].tasks.count()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder
    {
        var taskRoot = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.task_row,
                     parent,
                     false) as LinearLayout

        return TaskViewHolder(taskRoot)
    }

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int)
    {
        val thisTask = AppData.categories[index].tasks[position]
        val isLast = position == AppData.categories[index].tasks.count() -1
        holder.bindThisTask(thisTask, isLast)


        holder.itemView.setOnClickListener {



            taskClickListener.rowClicked(position)
        }

        holder.itemView.setOnLongClickListener {
            taskClickListener.rowLongClicked(position)

            true
        }

    }



}