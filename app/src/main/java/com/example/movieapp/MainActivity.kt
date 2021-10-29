package com.example.movieapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.movieapp.Adapter.MovieAdapter
import com.example.movieapp.models.Movie
import com.example.movieapp.models.MoviewResponse
import com.example.movieapp.services.MovieApiInterface
import com.example.movieapp.services.MovieApiService
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Response
import javax.security.auth.callback.Callback

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rv_movies_list.layoutManager = LinearLayoutManager(this)
        rv_movies_list.setHasFixedSize(true)
        getMovieData { movies : List<Movie> -> rv_movies_list.adapter = MovieAdapter(movies)

    }  }

    private fun getMovieData(callback: (List<Movie>) -> Unit){
        val apiService = MovieApiService.getInstance().create(MovieApiInterface::class.java)
        apiService.getMovieList().enqueue(object : retrofit2.Callback<MoviewResponse> {
            override fun onFailure(call: Call<MoviewResponse>, t: Throwable) {

            }

            override fun onResponse(call: Call<MoviewResponse>, response: Response<MoviewResponse>) {
                return callback(response.body()!!.moview)
            }

        })
    }
}


