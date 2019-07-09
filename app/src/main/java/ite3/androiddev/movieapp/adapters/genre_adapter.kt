package ite3.androiddev.movieapp.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView
import ite3.androiddev.movieapp.R
import ite3.androiddev.movieapp.models.Genre
import kotlinx.android.synthetic.main.item_genre.view.*

class GenreAdapter(private val genreList: List<Genre>) : RecyclerView.Adapter<GenreAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater
            .from(parent.context)
            .inflate(R.layout.item_genre,parent, false)
        )
    }

    override fun getItemCount(): Int {
        return genreList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.genreHolder.text = genreList[position].name
    }

    class ViewHolder(btn: View) : RecyclerView.ViewHolder(btn){
        val genreHolder: Button = btn.button
    }

}