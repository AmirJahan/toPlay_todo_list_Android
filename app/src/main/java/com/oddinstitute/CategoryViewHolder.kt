package com.oddinstitute

import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.oddinstitute.toplay.R
import com.oddinstitute.toplay.model.Category


class CategoryViewHolder(rootLayout: LinearLayout) :
        RecyclerView.ViewHolder(rootLayout)
{
    var categoryNameTextView: TextView? = null
    var categoryCountTextView: TextView? = null
    var categorySeparatorView: View? = null

    init
    {
        categoryNameTextView = itemView.findViewById(R.id.categoryNameTextView_id)
        categoryCountTextView = itemView.findViewById(R.id.categoryCountTextView_id)
        categorySeparatorView = itemView.findViewById(R.id.categorySeparator_id)
    }

    fun bindThisCategory(category: Category, isLast: Boolean = false)
    {
        categorySeparatorView?.let {
            if (isLast) it.visibility = View.GONE
            else it.visibility = View.VISIBLE
        }



        categoryNameTextView?.let {
            it.text = category.name
        }

        categoryCountTextView?.let {
            it.text = "${category.tasks.count()} games"
        }
    }
}
