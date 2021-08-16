package com.books.app.model

import com.google.gson.annotations.SerializedName

data class RemoteConfig(
    @SerializedName("books")
    val books: List<BookItemModel>,
    @SerializedName("top_banner_slides")
    val banner: List<BannerItemModel>,
    @SerializedName("you_will_like_section")
    val youWillLike: List<Int>
)