package com.books.app.details

import com.books.app.model.*
import javax.inject.Inject

class DetailsUseCase @Inject constructor(
    private val remoteConfigRepository: RemoteConfigRepository
) {

    fun invoke(): List<BookItemModel> {

        val result = remoteConfigRepository.config

        return result.books
    }

}