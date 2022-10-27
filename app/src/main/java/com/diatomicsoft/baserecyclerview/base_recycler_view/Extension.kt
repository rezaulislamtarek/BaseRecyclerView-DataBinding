package com.diatomicsoft.baserecyclerview.base_recycler_view

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

fun <T> RecyclerView.init(adapter: T, data: List<ListItemViewModel>){
    this.layoutManager = LinearLayoutManager(this.context)
    this.adapter = adapter as BaseAdapter<*>
    adapter.addItems(data as List<Nothing>)
}