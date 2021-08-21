package com.books.app.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.viewpager2.widget.ViewPager2
import com.books.app.App
import com.books.app.databinding.FragmentDetailsBinding
import com.books.app.model.BookItemModel
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

        val viewPager = binding.detailsTopSlider

        val topSliderAdapter = DetailsTopSliderAdapter()
        viewPager.adapter = topSliderAdapter

        viewModel.books.observe(viewLifecycleOwner, { books ->
            topSliderAdapter.setBookList(books)
            viewPager.setCurrentItem(args.bookId, false)
            setBookInfo(books[args.bookId])
        })

        with(viewPager) {
            clipToPadding = false
            clipChildren = false
            offscreenPageLimit = 3
        }

        viewPager.setPageTransformer(ViewPager2PageTransformation(requireContext()))

        binding.backArrow.setOnClickListener {
            val action = DetailsFragmentDirections.actionDetailsFragmentToBookListFragment()
            findNavController().navigate(action)
        }

        viewPager.registerOnPageChangeCallback(object :
            ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                if (topSliderAdapter.list.isNotEmpty()) {
                    val book = viewModel.getBookById(position)
                    setBookInfo(book)
                }
            }
        })

    }

    private fun setBookInfo(book: BookItemModel) {
        with(binding) {
            bookName.text = book.name
            bookAuthor.text = book.author
            readersInfo.text = book.views
            likesInfo.text = book.likes
            quotesInfo.text = book.quotes
            genreInfo.text = book.genre
            summaryInfo.text = book.summary
        }

    }

}