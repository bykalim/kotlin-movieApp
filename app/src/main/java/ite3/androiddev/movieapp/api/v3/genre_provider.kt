package ite3.androiddev.movieapp.api.v3

import android.app.Activity
import android.util.Log
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import ite3.androiddev.movieapp.api.ApiProvider.getRequest
import ite3.androiddev.movieapp.constants.Variables
import ite3.androiddev.movieapp.models.Genre
import okhttp3.*
import org.json.JSONException
import org.json.JSONObject
import java.io.IOException
import okhttp3.OkHttpClient



object GenreProvider {
    fun loadGenre(activity: Activity): List<Genre> {
        var genresList: List<Genre> = listOf()

        val client = OkHttpClient()

        val request = Request.Builder()
            .url("${Variables.baseUrl}/${Variables.apiVersion}/${Variables.genreListUrl}")
            .build()

        Log.d("hello","${Variables.baseUrl}/${Variables.apiVersion}/${Variables.genreListUrl}")
        Log.d("hello",request.body.toString())
//        getRequest(Variables.genreListUrl, object : Callback {
//            override fun onFailure(call: Call, e: IOException) {
//                print("request Fail")
//            }
//
//            override fun onResponse(call: Call, response: Response) {
//                val responseData = response.body?.string()
//                activity.run {
//                    runOnUiThread {
//                        try {
//                            val json = JSONObject(responseData)
//                            println("Request Successful!!")
//
//                            val genreType = object : TypeToken<List<Genre>>() {}.type
//                            val genreArray = json.getJSONArray("genres")
//                            genresList = Gson().fromJson(genreArray.toString(), genreType)
//                            Log.d("hello",genresList[0].name)
//                        } catch (e: JSONException) {
//                            e.printStackTrace()
//                        }
//                    }
//                }
//            }
//        })
//        genresList
//        Log.d("hello second",genresList[0].name)
        return genresList
    }

}