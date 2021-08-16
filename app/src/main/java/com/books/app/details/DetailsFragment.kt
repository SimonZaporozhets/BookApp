package com.books.app.details

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.books.app.App
import com.books.app.databinding.FragmentDetailsBinding
import com.books.app.model.BookItemModel
import com.bumptech.glide.Glide
import javax.inject.Inject


class DetailsFragment : Fragment() {

    private lateinit var binding: FragmentDetailsBinding
    private val args: DetailsFragmentArgs by navArgs()

    @Inject
    lateinit var viewModel: DetailsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        App.appComponent.inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.backArrow.setOnClickListener {
            val action = DetailsFragmentDirections.actionDetailsFragmentToBookListFragment()
            findNavController().navigate(action)
        }

        val id = args.bookId

        viewModel.books.observe(viewLifecycleOwner, { books ->
            val book = books[id]
            setBookInfo(book)
        })
    }

    private fun setBookInfo(book: BookItemModel) {

        Glide.with(requireContext()).load(book.cover_url)
            .centerCrop()
            .into(binding.bookCover)

        binding.bookName.text = book.name
        binding.bookAuthor.text = book.author
        binding.readersInfo.text = book.views
        binding.likesInfo.text = book.likes
        binding.quotesInfo.text = book.quotes
        binding.genreInfo.text = book.genre
        binding.summaryInfo.text = book.summary

    }

}