package com.books.app.library

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.books.app.model.BooksUiModels
import javax.inject.Inject

class LibraryViewModel @Inject constructor(private val libraryUseCase: LibraryUseCase) :
    ViewModel() {

    private val booksUiModel: MutableLiveData<List<BooksUiModels>> by lazy {
        MutableLiveData<List<BooksUiModels>>()
    }
    val books: LiveData<List<BooksUiModels>> get() = booksUiModel

    private fun initList() {
        val data = libraryUseCase.invoke()
        booksUiModel.value = data
    }

    init {
        initList()
    }

}