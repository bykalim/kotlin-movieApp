package ite3.androiddev.movieapp.fragments


import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

import ite3.androiddev.movieapp.R
import ite3.androiddev.movieapp.adapters.MovieAdapter
import ite3.androiddev.movieapp.constants.Variables
import ite3.androiddev.movieapp.models.Movie
import kotlinx.android.synthetic.main.fragment_search.*
import org.json.JSONObject

/**
 * A simple [Fragment] subclass.
 *
 */
class SearchFragment : Fragment() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager

    lateinit var movies: List<Movie>
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        submit.setOnClickListener {
            v ->
        }

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_search, container, false)
    }

    private fun performSearch() {
        val queue = Volley.newRequestQueue(context)
        val urlRequest = "${Variables.baseUrl}/${Variables.apiVersion}/${Variables.discoverUrl}}"
        val stringRequest = StringRequest(
            Request.Method.GET,
            urlRequest,
            Response.Listener<String> { response ->
                val responseData = JSONObject(response.toString())
                val responseResult = responseData.getJSONArray("results")
                val movieType = object : TypeToken<List<Movie>>() {}.type
                movies = Gson().fromJson(responseResult.toString(), movieType)

                viewManager = LinearLayoutManager(context)
                viewAdapter = MovieAdapter(movies)

                recyclerView = search_recycler.apply {
                    setHasFixedSize(true)
                    layoutManager = viewManager
                    adapter = viewAdapter
                }
            },
            Response.ErrorListener { Log.d("hello", "That didn't work!") })

        queue.add(stringRequest)
    }
}
