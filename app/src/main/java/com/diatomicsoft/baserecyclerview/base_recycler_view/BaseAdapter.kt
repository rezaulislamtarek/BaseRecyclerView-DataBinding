package com.diatomicsoft.baserecyclerview.base_recycler_view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.databinding.library.baseAdapters.BR
import androidx.recyclerview.widget.RecyclerView


class BaseAdapter<T : ListItemViewModel>(@LayoutRes val layoutId: Int) :
    RecyclerView.Adapter<BaseAdapter.BaseViewHolder<T>>() {
    private val items = mutableListOf<T>()
    private var inflater: LayoutInflater? = null
    private var onListItemViewClickListener: OnListItemViewClickListener? = null


    class BaseViewHolder<T : ListItemViewModel>(private val binding: ViewDataBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(itemViewModel: T) {
            binding.setVariable(BR.item, itemViewModel)
            binding.executePendingBindings()
        }
    }

    fun addItems(items: List<T>) {
        this.items.clear()
        this.items.addAll(items)
        notifyDataSetChanged()
    }

    fun setOnListItemViewClickListener(onListItemViewClickListener: OnListItemViewClickListener?) {
        this.onListItemViewClickListener = onListItemViewClickListener
    }

    interface OnListItemViewClickListener {
        fun onClick(view: View, position: Int)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<T> {
        val layoutInflater = inflater ?: LayoutInflater.from(parent.context)
        val binding =
            DataBindingUtil.inflate<ViewDataBinding>(layoutInflater, layoutId, parent, false)
        return BaseViewHolder(binding)
    }

    override fun onBindViewHolder(holder: BaseViewHolder<T>, position: Int) {
        val itemViewModel = items[position]
        itemViewModel.adapterPosition = position
        onListItemViewClickListener?.let { itemViewModel.onListItemViewClickListener = it }
        holder.bind(itemViewModel)
    }

    override fun getItemCount(): Int = items.size
}