package com.oddinstitute.toplay

import android.graphics.Color
import android.graphics.Paint
import android.view.View
import android.widget.CheckBox
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.oddinstitute.toplay.model.Task
import java.util.*


class TaskViewHolder(rootLayout: LinearLayout) :
        RecyclerView.ViewHolder(rootLayout)
{
    var itemNameTextView: TextView? = null
    var itemCheckBox: CheckBox? = null
    var itemSeparatorView: View? = null

    init
    {
        itemNameTextView = itemView.findViewById(R.id.taskNameTextView_id)
        itemCheckBox = itemView.findViewById(R.id.taskCheckBox_id)
        itemSeparatorView = itemView.findViewById(R.id.taskSeparator_id)
    }

    fun bindThisTask(task: Task, isLast: Boolean = false)
    {
        itemSeparatorView?.let {
            if (isLast) it.visibility = View.GONE
            else it.visibility = View.VISIBLE
        }

        itemNameTextView?.let {
            it.text = task.name
        }


        if (task.isDone) //
        {
            itemView.setBackgroundColor(Color.LTGRAY)

            itemNameTextView?.let {
                it.paintFlags = it.paintFlags or
                        Paint.STRIKE_THRU_TEXT_FLAG
            }
        }
        else
        {
            itemView.setBackgroundColor(Color.TRANSPARENT)
            itemNameTextView?.let {
                it.paintFlags = it.paintFlags and
                        Paint.STRIKE_THRU_TEXT_FLAG.inv()
            }
        }


        itemCheckBox?.let {
            it.isChecked = task.isDone
        }
    }
}
