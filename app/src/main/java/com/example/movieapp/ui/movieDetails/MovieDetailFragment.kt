package com.example.movieapp.ui.movieDetails

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.View
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.movieapp.R
import com.example.movieapp.application.AppConstants
import com.example.movieapp.databinding.FragmentMovieDetailBinding


class MovieDetailFragment : Fragment(R.layout.fragment_movie_detail) {

    private lateinit var binding: FragmentMovieDetailBinding
    private val args by navArgs<MovieDetailFragmentArgs>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentMovieDetailBinding.bind(view)
        Glide.with(requireContext()).load("${AppConstants.BASE_URL_IMAGE}${args.posterImageUrl}").centerCrop().into(binding.imgMovie)
        Glide.with(requireContext()).load("${AppConstants.BASE_URL_IMAGE}${args.backgroundImageUrl}").centerCrop().into(binding.imgBackground)
        binding.txtDescription.text = args.overview
        binding.txtLanguage.text = "Languaje ${args.languaje}"
        binding.txtMovieTitle.text = args.title
        binding.txtRating.text = "${args.voteAverage}  (${args.voteCount} Reviews)"
        binding.txtRelease.text = "Released ${args.releaseDate}"
    }
}