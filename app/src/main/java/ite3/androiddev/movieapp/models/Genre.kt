package ite3.androiddev.movieapp.models
import com.google.gson.annotations.SerializedName

class Genre(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String
)