package ite3.androiddev.movieapp.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import ite3.androiddev.movieapp.R
import ite3.androiddev.movieapp.constants.Variables
import ite3.androiddev.movieapp.models.Movie
import kotlinx.android.synthetic.main.movie_card.view.*

class MovieAdapter( private val dataset: List<Movie>) : RecyclerView.Adapter<MovieAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.movie_card, parent,false) )
    }

    override fun getItemCount(): Int {
        return dataset.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val imageUrl = Variables.imageUrl + dataset[position].posterPath
        Glide.with(holder.holder_image.context)
            .load(imageUrl)
            .into(holder.holder_image)

        holder.holder_title.text = dataset[position].title
        holder.holder_subtitle.text = dataset[position].overview
        holder.holder_rating.rating = (dataset[position].voteAverage / 2).toFloat()
    }

    class ViewHolder( itemView: View): RecyclerView.ViewHolder(itemView) {
        var holder_image = itemView.movieCard_image
        var holder_title = itemView.movieCard_title
        var holder_subtitle = itemView.movieCard_detail
        var holder_rating = itemView.movieCard_ratingBar
    }


}