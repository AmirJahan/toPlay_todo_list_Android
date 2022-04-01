package com.oddinstitute.toplay

interface CategoryClickListener
{
    fun rowClicked (index: Int)
    fun rowLongClicked (index: Int)
}

interface TaskClickListener
{
    fun rowClicked (index: Int)
    fun rowLongClicked (index: Int)
}