package com.books.app.details

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.books.app.databinding.DetailsTopSliderItemBinding
import com.books.app.model.BookItemModel
import com.bumptech.glide.Glide

class DetailsTopSliderAdapter : RecyclerView.Adapter<DetailsViewHolder>() {

    var list: List<BookItemModel> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DetailsViewHolder {
        val itemBinding =
            DetailsTopSliderItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return DetailsViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: DetailsViewHolder, position: Int) {
        Glide.with(holder.itemView.context).load(list[position].cover_url)
            .centerCrop()
            .into(holder.binding.bookCover)
    }

    fun setBookList(list: List<BookItemModel>) {
        this.list = list.sortedBy { it.id }
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = list.size
}

class DetailsViewHolder(val binding: DetailsTopSliderItemBinding) :
    RecyclerView.ViewHolder(binding.root)