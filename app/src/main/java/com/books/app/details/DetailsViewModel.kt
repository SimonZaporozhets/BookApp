package com.books.app.details

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.books.app.model.BookItemModel
import javax.inject.Inject

class DetailsViewModel @Inject constructor(private val detailsUseCase: DetailsUseCase) :
    ViewModel() {

    private val booksUiModel: MutableLiveData<List<BookItemModel>> by lazy {
        MutableLiveData<List<BookItemModel>>()
    }
    val books: LiveData<List<BookItemModel>> get() = booksUiModel

    private fun initList() {
        val data = detailsUseCase.invoke()
        booksUiModel.value = data
    }

    init {
        initList()
    }

}