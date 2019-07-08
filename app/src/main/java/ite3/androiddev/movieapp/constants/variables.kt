package ite3.androiddev.movieapp.constants

object Variables {
    val imageUrl = "https://image.tmdb.org/t/p/original"
    val baseUrl = "https://api.themoviedb.org"
    val apiVersion = "3"

    val baseApi = "$baseUrl/$apiVersion/"
    val apiKey = "12692a5a048a5a33c53000134de8a0d6"
    val genreListUrl = "genre/movie/list?api_key=$apiKey"
    val nowPlayingUrl = "movie/now_playing?api_key=$apiKey&language=en-US&page=1"
}