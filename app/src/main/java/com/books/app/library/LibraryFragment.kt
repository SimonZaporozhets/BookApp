package com.books.app.library

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.books.app.App
import com.books.app.databinding.FragmentLibraryBinding
import com.books.app.library.adapters.ParentItemAdapter
import javax.inject.Inject


class LibraryFragment : Fragment() {


    private lateinit var binding: FragmentLibraryBinding

    @Inject
    lateinit var viewModel: LibraryViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        App.appComponent.inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentLibraryBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val onItemClickListener: (Int) -> Unit = { item ->
            val action = LibraryFragmentDirections.actionBookListFragmentToDetailsFragment(item)
            findNavController().navigate(action)
        }

        val parentItemAdapter = ParentItemAdapter(onItemClickListener)

        val linearLayoutManager = LinearLayoutManager(context)

        binding.parentRecyclerView.adapter = parentItemAdapter
        binding.parentRecyclerView.layoutManager = linearLayoutManager

        viewModel.books.observe(viewLifecycleOwner, { finalList ->
            parentItemAdapter.submitList(finalList)
        })

    }
}