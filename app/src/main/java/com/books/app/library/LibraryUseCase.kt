package com.books.app.library

import com.books.app.model.RemoteConfigRepository
import com.books.app.model.BannerListModel
import com.books.app.model.BookListItemModel
import com.books.app.model.BooksUiModels
import javax.inject.Inject

class LibraryUseCase @Inject constructor(
    private val remoteConfigRepository: RemoteConfigRepository
) {

    fun invoke(): List<BooksUiModels> {

        val result = remoteConfigRepository.config

        val finalList = mutableListOf<BooksUiModels>()

        finalList.add(BannerListModel(result.banner))

        val groupedBookList = result.books.groupBy { it.genre }

        groupedBookList.forEach { (genre, bookList) ->
            finalList.add(BookListItemModel(genre, bookList))
        }

        return finalList
    }

}