package com.diatomicsoft.baserecyclerview

import com.diatomicsoft.baserecyclerview.base_recycler_view.BaseAdapter
import com.diatomicsoft.baserecyclerview.base_recycler_view.ListItemViewModel

data class ListClass(var list:List<UserModel>, var adapter: BaseAdapter<UserModel>)
