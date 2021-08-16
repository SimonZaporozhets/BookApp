package com.books.app.library.viewholders

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.books.app.BannerAdapter
import com.books.app.R
import com.books.app.databinding.BannerItemBinding
import com.books.app.model.BannerListModel
import com.google.android.material.tabs.TabLayoutMediator

class BannerParentViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val binding = BannerItemBinding.bind(itemView)

        fun bind(bannerListModel: BannerListModel, clickListener: (Int) -> Unit) {

            val bannerAdapter = BannerAdapter(bannerListModel.bannerItemList, clickListener)

            binding.topBanner.adapter = bannerAdapter

            TabLayoutMediator(binding.tabLayout, binding.topBanner) { tab, position ->
                //Some implementation
            }.attach()

        }

        companion object {
            const val LAYOUT_ID = R.layout.banner_item
        }
    }