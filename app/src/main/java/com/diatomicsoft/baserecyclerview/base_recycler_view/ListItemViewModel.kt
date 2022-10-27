package com.diatomicsoft.baserecyclerview.base_recycler_view

abstract class ListItemViewModel {
    var adapterPosition: Int = -1
    var onListItemViewClickListener: BaseAdapter.OnListItemViewClickListener? = null
}