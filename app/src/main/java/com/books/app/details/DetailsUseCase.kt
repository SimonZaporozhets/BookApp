package com.books.app.details

import com.books.app.model.BookItemModel
import com.books.app.model.RemoteConfigRepository
import javax.inject.Inject

class DetailsUseCase @Inject constructor(
    private val remoteConfigRepository: RemoteConfigRepository
) {

    fun invoke(): List<BookItemModel> {

        val result = remoteConfigRepository.config

        return result.books
    }

    fun getBookById(id: Int): BookItemModel {
        return invoke()[id]
    }

}