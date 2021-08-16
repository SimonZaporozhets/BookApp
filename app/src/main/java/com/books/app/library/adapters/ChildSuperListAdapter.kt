package com.books.app.library.adapters

import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

abstract class ChildSuperListAdapter<T, VH : RecyclerView.ViewHolder>(
    diffCallback: DiffUtil.ItemCallback<T>
) : ListAdapter<T, VH>(diffCallback) {


    final override fun onBindViewHolder(holder: VH, position: Int) {
        onBindViewHolder(holder, getItem(position))

    }

    abstract fun onBindViewHolder(holder: VH, item: T)
}
