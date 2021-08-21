package com.books.app.library.viewholders

import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.books.app.R
import com.books.app.databinding.ParentRvItemsBinding
import com.books.app.library.adapters.ChildListAdapter
import com.books.app.model.BookListItemModel

class BookListItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val viewPool = RecyclerView.RecycledViewPool()

    private val binding = ParentRvItemsBinding.bind(itemView)

    fun bind(bookListItemModel: BookListItemModel, clickListener: (Int) -> Unit) {

        binding.bookCategory.text = bookListItemModel.title

        val layoutManager = LinearLayoutManager(
            binding.childRv
                .context,
            LinearLayoutManager.HORIZONTAL,
            false
        )

        layoutManager.initialPrefetchItemCount = bookListItemModel
            .subList
            .size

        val childItemAdapter = ChildListAdapter(
            bookListItemModel
                .subList, clickListener
        )

        binding.childRv.layoutManager = layoutManager
        binding.childRv.adapter = childItemAdapter
        binding.childRv.setRecycledViewPool(viewPool)
    }

    companion object {
        const val LAYOUT_ID = R.layout.parent_rv_items
    }
}