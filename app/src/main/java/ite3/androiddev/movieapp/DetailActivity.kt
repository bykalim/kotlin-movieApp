package ite3.androiddev.movieapp

import android.os.Bundle
import android.util.Log
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.bumptech.glide.Glide
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import ite3.androiddev.movieapp.adapters.GenreAdapter
import ite3.androiddev.movieapp.constants.Variables
import ite3.androiddev.movieapp.models.MovieDetail

import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.android.synthetic.main.content_detail.*

class DetailActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager

    lateinit var movieDetail: MovieDetail
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)



        val movieId = intent.getIntExtra("movieId",0)
        val queue = Volley.newRequestQueue(this)
        val urlRequest = "${Variables.baseUrl}/${Variables.apiVersion}/movie/$movieId?api_key=${Variables.apiKey}"
        Log.d("hello",urlRequest)
        val stringRequest = StringRequest(
            Request.Method.GET,
            urlRequest,
            Response.Listener<String> { response ->
                val movieDetailType = object : TypeToken<MovieDetail>(){}.type
                movieDetail = Gson().fromJson(response.toString(),movieDetailType)

                detailTitle.text = movieDetail.title
                detailSubtitle.text = movieDetail.releaseDate + " // " + movieDetail.status
                detailOverview.text = movieDetail.overview

                val imageUrl = Variables.imageUrl + movieDetail.posterPath
                Glide.with(detailImage)
                    .load(imageUrl)
                    .into(detailImage)

                viewManager = LinearLayoutManager(this)
                viewAdapter = GenreAdapter(movieDetail.genres)
                recyclerView = genre_recycler.apply {
                    layoutManager = viewManager
                    adapter = viewAdapter
                }

            },
            Response.ErrorListener { Log.d("hello","That didn't work!" )})

        queue.add(stringRequest)


        fab.setOnClickListener { view ->
            Snackbar
                .make(view, "You have book a ticket", Snackbar.LENGTH_LONG)
                .setAction("Action", null)
                .show()
        }
    }

}
