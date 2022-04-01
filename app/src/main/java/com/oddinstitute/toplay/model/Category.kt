package com.oddinstitute.toplay.model

data class Category(val name: String,
                    var tasks: MutableList<Task> = mutableListOf())