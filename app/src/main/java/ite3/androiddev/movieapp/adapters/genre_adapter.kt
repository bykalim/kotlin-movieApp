package ite3.androiddev.movieapp.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.button.MaterialButton
import ite3.androiddev.movieapp.R
import ite3.androiddev.movieapp.models.Genre
import kotlinx.android.synthetic.main.categories_chip.view.*

class GenreAdapter(private val genreList: Array<Genre>) : RecyclerView.Adapter<GenreAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val btn = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.categories_chip,parent, false) as MaterialButton
        return ViewHolder(btn)
    }

    override fun getItemCount(): Int {
        return genreList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemView.chipBtn.text = genreList[position].name
    }

    class ViewHolder(btn:MaterialButton) : RecyclerView.ViewHolder(btn)

}