package com.books.app.model

sealed class BooksUiModels

data class BookItemModel(
    val id: Int,
    val name: String,
    val author: String,
    val summary: String,
    val genre: String,
    val cover_url: String,
    val views: String,
    val likes: String,
    val quotes: String
)

data class BannerItemModel(val id: Int, val book_id: Int, val cover: String)

data class BannerListModel(
    var bannerItemList: List<BannerItemModel>
) : BooksUiModels()

data class BookListItemModel(
    var title: String? = "",
    var subList: List<BookItemModel>
) : BooksUiModels()

