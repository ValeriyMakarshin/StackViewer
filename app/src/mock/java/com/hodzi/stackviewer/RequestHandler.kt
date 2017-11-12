package com.hodzi.stackviewer

import android.content.Context
import okhttp3.Request
import okhttp3.Response
import java.io.IOException
import java.lang.ref.WeakReference

class RequestHandler(context: Context) {
    private val contextWeakRef: WeakReference<Context> = WeakReference(context)

    private val responses: HashMap<Regex, String> = HashMap()

    init {
        responses.put(Regex("/questions/[0-9]{1,14}/answers\$"), "answers.json")
        responses.put(Regex("/questions\$"), "questions.json")
        responses.put(Regex("/tags\$"), "tags.json")
        responses.put(Regex("/users\$"), "users.json")
    }

    fun intercept(path: String): Boolean = responses.keys.any { path.contains(it) }

    fun proceed(request: Request, path: String): Response? {
        responses.keys.filter { path.contains(it) }
            .forEach { return createResponseFromAssets(request, responses[it]) }
        return null
    }

    private fun createResponseFromAssets(request: Request, assetPath: String?): Response {
        return try {
            val stream = contextWeakRef.get()?.assets?.open(assetPath)

            stream.use { inputStream ->
                if (inputStream != null) {
                    OkHttpResponse.success(request, inputStream)
                } else {
                    OkHttpResponse.error(request, 500, "null stream")
                }
            }
        } catch (e: IOException) {
            OkHttpResponse.error(request, 500, e.message!!)
        }
    }
}