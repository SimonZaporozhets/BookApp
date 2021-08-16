package com.books.app.library.adapters

import android.content.res.Resources
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.books.app.model.BannerListModel
import com.books.app.model.BookListItemModel
import com.books.app.model.BooksUiModels
import com.books.app.library.viewholders.BannerParentViewHolder
import com.books.app.library.viewholders.BookListItemViewHolder


class ParentItemAdapter(private val itemClickListener: (Int) -> Unit) :
    ChildSuperListAdapter<BooksUiModels, RecyclerView.ViewHolder>(diffUtil) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(viewType, parent, false)

        return when (viewType) {
            BannerParentViewHolder.LAYOUT_ID -> BannerParentViewHolder(view)
            BookListItemViewHolder.LAYOUT_ID -> BookListItemViewHolder(view)
            else -> throw Resources.NotFoundException("NotFound LAYOUT_ID for adapter")
        }
    }

    override fun getItemViewType(position: Int): Int {
        return when (getItem(position)) {
            is BannerListModel -> BannerParentViewHolder.LAYOUT_ID
            is BookListItemModel -> BookListItemViewHolder.LAYOUT_ID
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, item: BooksUiModels) {
        when (item) {
            is BannerListModel -> (holder as BannerParentViewHolder).bind(item, itemClickListener)
            is BookListItemModel -> (holder as BookListItemViewHolder).bind(
                item,
                itemClickListener
            )
        }

    }
}

val diffUtil = object : DiffUtil.ItemCallback<BooksUiModels>() {

    override fun areItemsTheSame(
        oldItem: BooksUiModels,
        newItem: BooksUiModels
    ) =
        oldItem.hashCode() == newItem.hashCode()

    override fun areContentsTheSame(
        oldItem: BooksUiModels,
        newItem: BooksUiModels
    ) =
        oldItem == newItem

}