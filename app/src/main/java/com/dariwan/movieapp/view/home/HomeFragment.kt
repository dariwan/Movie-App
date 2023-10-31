package com.dariwan.movieapp.view.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.dariwan.movieapp.R
import com.dariwan.movieapp.core.data.Resource
import com.dariwan.movieapp.core.ui.NewsVerticalAdapter
import com.dariwan.movieapp.core.ui.SectionPagerAdapter
import com.dariwan.movieapp.databinding.FragmentHomeBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private val homeViewModel: HomeViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
       return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupFragment()
    }

    private fun setupFragment() {
        if (activity != null){
            val newsVerticalAdapter = NewsVerticalAdapter()
            newsVerticalAdapter.onItemClick = {selectData ->

            }

            homeViewModel.movie.observe(viewLifecycleOwner) {movie ->
                if (movie != null){
                    when(movie){
                        is Resource.Success -> {
                            newsVerticalAdapter.setData(movie.data)
                        }
                        is Resource.Error -> {
                            Toast.makeText(requireContext(), "error", Toast.LENGTH_SHORT).show()
                        }
                        is Resource.Loading -> {

                        }
                    }
                }
            }
            with(binding.rvMoviePopular){
                layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
                setHasFixedSize(true)
                adapter= newsVerticalAdapter
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}