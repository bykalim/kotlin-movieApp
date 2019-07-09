package ite3.androiddev.movieapp.constants

object Variables {
    val imageUrl = "https://image.tmdb.org/t/p/original"
    val baseUrl = "https://api.themoviedb.org"
    val apiVersion = "3"

    val baseApi = "$baseUrl/$apiVersion/"
    val apiKey = "12692a5a048a5a33c53000134de8a0d6"
    val genreListUrl = "genre/movie/list?api_key=$apiKey"
    val nowPlayingUrl = "movie/now_playing?api_key=$apiKey&language=en-US&page=1"
    val trendingUrl: String = "movie/top_rated?api_key=$apiKey&language=en-US&page=1"
    val discoverUrl: String = "discover/movie?api_key=$apiKey&language=en-US&sort_by=popularity.desc&include_adult=false&include_video=false&page=1"
    val searchUrl: String = "search/movie?api_key=$apiKey&language=en-US&query="
}