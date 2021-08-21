package com.books.app

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.books.app.databinding.BannerChildItemBinding
import com.books.app.model.BannerItemModel
import com.bumptech.glide.Glide

class BannerAdapter(private val mList: List<BannerItemModel>, val clickListener: (Int) -> Unit) :
    RecyclerView.Adapter<BannerViewHolder>() {

    private val books = mList

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BannerViewHolder {
        val itemBinding =
            BannerChildItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return BannerViewHolder(itemBinding)
    }

    override fun getItemCount(): Int = books.size

    override fun onBindViewHolder(holder: BannerViewHolder, position: Int) {
        holder.binding.bannerItemWrapper.setOnClickListener { clickListener(books[position].book_id) }
        val imageUrl = books[position].cover
        Glide.with(holder.itemView.context).load(imageUrl)
            .centerCrop()
            .into(holder.binding.bannerItemImage)
    }
}

class BannerViewHolder(val binding: BannerChildItemBinding) : RecyclerView.ViewHolder(binding.root)