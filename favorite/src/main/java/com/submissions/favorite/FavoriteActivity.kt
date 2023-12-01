package com.submissions.favorite

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.submissions.core.domain.model.Movie
import com.submissions.core.ui.MovieAdapter
import com.submissions.favorite.databinding.ActivityFavoriteBinding
import com.submissions.movlist.ui.detail.DetailActivity
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.context.loadKoinModules

class FavoriteActivity : AppCompatActivity() {

    private val favoriteViewModel: FavoriteViewModel by viewModel()
    private lateinit var binding: ActivityFavoriteBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFavoriteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.title = "Favorite"

        loadKoinModules(favoriteModule)

        favoriteViewModel.favoriteMovie.observe(this) { listMovie ->
            setupList(listMovie)
        }
    }

    private fun setupList(listMovie: List<Movie>?) {
        if (listMovie != null) {
            val movieAdapter = MovieAdapter()
            movieAdapter.onItemClick = { selectedData ->
                val intent = Intent(this, DetailActivity::class.java)
                intent.putExtra(DetailActivity.EXTRA_DATA, selectedData)
                startActivity(intent)
            }
            favoriteViewModel.favoriteMovie.observe(this) { listMovies ->
                movieAdapter.setData(listMovies)
                binding.viewEmpty.visibility =
                    if (listMovies.isNotEmpty()) View.GONE else View.VISIBLE
            }
            with(binding.rvTourism) {
                val lm = GridLayoutManager(this@FavoriteActivity, 2)
                layoutManager = lm
                setHasFixedSize(true)
                adapter = movieAdapter
            }
        }
    }
}