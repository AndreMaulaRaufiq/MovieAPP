package com.submissions.movlist.ui.detail

import android.os.Bundle
import android.view.View
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import com.submissions.core.domain.model.Movie
import com.submissions.movlist.R
import com.submissions.movlist.databinding.ActivityDetailBinding
import org.koin.androidx.viewmodel.ext.android.viewModel
import kotlin.math.abs

@Suppress("DEPRECATION")
class DetailActivity : AppCompatActivity() {
    companion object {
        const val EXTRA_DATA = "extra_data"
    }

    private val threshold = 0.9f
    private lateinit var binding: ActivityDetailBinding
    private val detailMovieViewModel: DetailViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        )
        val movieDetail = intent.getParcelableExtra<Movie>(EXTRA_DATA)
        showDetailMovie(movieDetail)

        binding.appBar.addOnOffsetChangedListener { _, verticalOffset ->
            if (abs(verticalOffset) < threshold * binding.appBar.totalScrollRange) {
                binding.tvDetailRating.visibility = View.VISIBLE
            } else {
                binding.tvDetailRating.visibility = View.GONE
            }
        }
    }

    private fun showDetailMovie(movieDetail: Movie?) {
        movieDetail?.let {
            binding.content.tvDetailTitle.text = movieDetail.title
            val formattedRating = String.format("%.1f", movieDetail.voteAverage)
            binding.tvDetailRating.text = formattedRating
            binding.content.tvDetailReleaseDate.text = movieDetail.releaseDate
            binding.content.tvDetailDescription.text = movieDetail.overview
            Glide.with(this@DetailActivity)
                .load("http://image.tmdb.org/t/p/w500/${movieDetail.posterPath}")
                .into(binding.ivDetailImage)

            var statusFavorite = movieDetail.isFavorite
            setStatusFavorite(statusFavorite)
            binding.fab.setOnClickListener {
                statusFavorite = !statusFavorite
                detailMovieViewModel.setFavoriteMovie(movieDetail, statusFavorite)
                setStatusFavorite(statusFavorite)
            }
        }
    }

    private fun setStatusFavorite(statusFavorite: Boolean) {
        if (statusFavorite) {
            binding.fab.setImageDrawable(
                ContextCompat.getDrawable(
                    this,
                    R.drawable.favorite_24
                )
            )
        } else {
            binding.fab.setImageDrawable(
                ContextCompat.getDrawable(
                    this,
                    R.drawable.favorite_border_24
                )
            )
        }
    }

}