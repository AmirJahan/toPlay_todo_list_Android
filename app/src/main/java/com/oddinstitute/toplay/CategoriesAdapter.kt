package com.oddinstitute.toplay

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.recyclerview.widget.RecyclerView
import com.oddinstitute.CategoryViewHolder

class CategoriesAdapter (val categoriesListener: CategoryClickListener)
    : RecyclerView.Adapter <CategoryViewHolder>()
{
    override fun getItemCount(): Int = AppData.categories.count()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder
    {
        var categoryRoot = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.category_row,
                     parent,
                     false) as LinearLayout

        return CategoryViewHolder(categoryRoot)
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int)
    {
        val theCategory = AppData.categories[position]
        val isLast = position == AppData.categories.count() - 1
        holder.bindThisCategory(theCategory, isLast)


        holder.itemView.setOnClickListener {
            categoriesListener.rowClicked(position)
        }

        holder.itemView.setOnLongClickListener {
            categoriesListener.rowLongClicked(position)

            true
        }
    }
}