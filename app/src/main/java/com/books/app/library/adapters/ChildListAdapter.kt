package com.books.app.library.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.books.app.R
import com.books.app.model.BookItemModel
import com.bumptech.glide.Glide

class ChildListAdapter(private val mList: List<BookItemModel>, val clickListener: (Int) -> Unit) :
    RecyclerView.Adapter<ChildListAdapter.ChildViewHolder>() {

    private val childItemList = mList

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChildViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.book_list_item, parent, false)

        return ChildViewHolder(view)
    }

    override fun onBindViewHolder(holderChild: ChildViewHolder, position: Int) {

        holderChild.layout.setOnClickListener { clickListener(childItemList[position].id) }

        val item = childItemList[position]

        Glide.with(holderChild.itemView.context).load(item.cover_url)
            .centerCrop()
            .into(holderChild.imageView)

        holderChild.textView.text = item.name

    }

    override fun getItemCount(): Int {
        return childItemList.size
    }

    class ChildViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val imageView: ImageView = itemView.findViewById(R.id.book_image)
        val textView: TextView = itemView.findViewById(R.id.book_name)
        val layout: LinearLayout = itemView.findViewById(R.id.book_list_item_wrapper)
    }
}