package ite3.androiddev.movieapp.api
import android.content.Context
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import ite3.androiddev.movieapp.constants.Variables
import okhttp3.*


object ApiProvider {
    private val client: OkHttpClient = OkHttpClient()

//    /**\
//     * @param url is request url string
//     * @callback is response event for fail callback and success callback
//     */
//    fun getRequest(url: String, callback: Callback): Call {
//        val builder = OkHttpClient.Builder()
//        if (BuildConfig.DEBUG) {
//            builder.addInterceptor(OkHttpProfilerInterceptor() )
//        }
//        val client = builder.build()
//
//        val requestUrl = "${Variables.baseUrl}/${Variables.apiVersion}/$url"
//        val request = Request.Builder()
//            .url(requestUrl)
//            .build()
//
//        val call = client.newCall(request)
//        call.enqueue(callback)
//        Log.d("Hello","Requesting: $requestUrl")
//        return call
//    }

    @JvmStatic
    fun getRequest(url: String, context: Context){
        val queue = Volley.newRequestQueue(context)

        val urlRequest = "${Variables.baseUrl}/${Variables.apiVersion}/${Variables.nowPlayingUrl}"
        val stringRequest = StringRequest(
            com.android.volley.Request.Method.GET,
            url,
            Response.Listener<String> { response ->
            },
            Response.ErrorListener {

            })

        queue.add(stringRequest)
    }

    fun POST(url: String, parameters: HashMap<String, String>, callback: Callback): Call {
        val builder = FormBody.Builder()
        val it = parameters.entries.iterator()
        while (it.hasNext()) {
            val pair = it.next() as Map.Entry<*, *>
            builder.add(pair.key.toString(), pair.value.toString())
        }

        val formBody = builder.build()
        val request = Request.Builder()
            .url(url)
            .post(formBody)
            .build()


        val call = client.newCall(request)
        call.enqueue(callback)
        return call
    }
}